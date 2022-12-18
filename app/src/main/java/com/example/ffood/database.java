package com.example.ffood;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;

import androidx.annotation.Nullable;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class database extends SQLiteOpenHelper {
    private Context context;
    private static final String DATABASE_NAME = "FoodDelivary.db";
    private static final int DATABASE_VERSION =1;

    private static final String Table_Name="Login";
    private static final String Column_Id="id";
    private static final String User_Name="user";
    private static final String Password="Password";



    public database(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    String query = "CREATE TABLE "+Table_Name+
            "("+Column_Id+"INTEGER PRIMARY KEY AUTOINCREMENT,"+
            User_Name+"Text,"+
            Password+"Text);";

    String query2 = "CREATE TABLE "+"Resto"+
            "("+"Resto_ID"+"INTEGER PRIMARY KEY AUTOINCREMENT,"+
            "Resto_Name"+"Text,"+
            "Adress_Resto"+"Text,"+
            "Email_Resto"+"Text,"+
            "Numero_Resto"+"Text);";

    String query3 = "CREATE TABLE "+"Food"+
            "("+"Food_ID"+"INTEGER PRIMARY KEY AUTOINCREMENT,"+
            "Food_Name"+"Text,"+
            "Food_Price"+"DOUBLE ,"+
            "Food_Description"+"Text ,"+
            "Food_Image"+"BLOB ,"+
            "RI"+"INTEGER,"+
            "FOREIGN KEY ("+"RI"+") REFERENCES "+"Resto"+" ("+"Resto_ID"+"));";

    String query4 = "CREATE TABLE "+"Commande"+
            "("+"Commande_ID"+"INTEGER PRIMARY KEY AUTOINCREMENT,"+
            "Commande_Name"+"Text,"+
            "Adress"+"Text,"+
            "RI"+"INTEGER,"+
            "FI"+"INTEGER,"+
            "Amount"+"INTEGER,"+
            "Date"+"DATETIME,"+
            "FOREIGN KEY ("+"FI"+") REFERENCES "+"Food"+" ("+"Food_ID"+"),"+
            "FOREIGN KEY ("+"RI"+") REFERENCES "+"Resto"+" ("+"Resto_ID"+"));";

        db.execSQL(query);
        db.execSQL(query2);
        db.execSQL(query3);
        db.execSQL(query4);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+Table_Name);
        db.execSQL("DROP TABLE IF EXISTS "+"Resto");
        db.execSQL("DROP TABLE IF EXISTS "+"Food");
        db.execSQL("DROP TABLE IF EXISTS "+"Commande");
        onCreate(db);
    }


    //login
    public Boolean checkusernamepass (String username,String password){
        SQLiteDatabase db= this.getReadableDatabase();
        Cursor cursor  = db. rawQuery ( "select * from Login where user=? and Password=?", new String[] {username,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
    // R1
    public void addResto(String RestoName, String AdressResto, String EmailResto, String NumeroResto) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("Resto_Name", RestoName);
        values.put("Adress_Resto", AdressResto);
        values.put("Email_Resto", EmailResto);
        values.put("Numero_Resto", NumeroResto);


        db.insert("Resto", null, values);
        db.close();
    }

//R2
    public ArrayList<RestoClass> readResto() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor Cursor = db.rawQuery("SELECT * FROM " + "Resto", null);

        ArrayList<RestoClass> RestoArrayList = new ArrayList<>();

        if (Cursor.moveToFirst()) {
            do {
                RestoArrayList.add(new RestoClass(Cursor.getString(1),
                        Cursor.getString(2),
                        Cursor.getString(3),
                        Cursor.getString(4)));
            } while (Cursor.moveToNext());
        }

        Cursor.close();
        return RestoArrayList;
    }
//R3
    public void deleteResto(String RestoName) {

        // on below line we are creating
        // a variable to write our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are calling a method to delete our
        // course and we are comparing it with our course name.
        db.delete("Resto", "Food_Name=?", new String[]{RestoName});
        db.close();
    }
//R4
    public void updateresto(String originalResto, String RestoName, String AdressResto,
                             String EmailResto, String NumeroResto) {

        // calling a method to get writable database.
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put("Resto_Name", RestoName);
        values.put("Adress_Resto", AdressResto);
        values.put("Email_Resto", EmailResto);
        values.put("Numero_Resto", NumeroResto);

        // on below line we are calling a update method to update our database and passing our values.
        // and we are comparing it with name of our course which is stored in original name variable.
        db.update("Resto", values, "Resto_Name=?", new String[]{originalResto});
        db.close();
    }
//F1
    public void addFood(String FoodName, double FoodPrice, String FoodDescription, String FoodImage, int RestoName) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();


        try{
        FileInputStream fileInputStream = new FileInputStream(FoodImage);
        byte [] img = new byte[fileInputStream.available()];
        fileInputStream.read(img);
            values.put("Food_Name", FoodName);
            values.put("Food_Price", FoodPrice);
            values.put("Food_Description", FoodDescription);
            values.put("Food_Image", img);
            values.put("RI", RestoName);
            db.insert("Resto", null, values);
            fileInputStream.close();
            db.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }


    }
    //F2
    public ArrayList<Food> readFood() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor Cursor = db.rawQuery("SELECT * FROM " + "Food", null);

        ArrayList<Food> FoodArrayList = new ArrayList<>();

        if (Cursor.moveToFirst()) {
            do {
                FoodArrayList.add(new Food(Cursor.getString(1),
                        Cursor.getDouble(2),
                        Cursor.getString(3),
                        Cursor.getBlob(4),
                        Cursor.getInt(5))

                );
            } while (Cursor.moveToNext());
        }

        Cursor.close();
        return FoodArrayList;
    }
//F3
    public void deletefood(String foodName) {


        SQLiteDatabase db = this.getWritableDatabase();


        db.delete("Food", "Food_Name=?", new String[]{foodName});
        db.close();
    }
//f4
public void updatefoood(String originalfood, String Foodname, String Fooddesc,
                        double price, String FoodImage,int ri) {

    // calling a method to get writable database.
    SQLiteDatabase db = this.getWritableDatabase();
    ContentValues values = new ContentValues();


    try{
        FileInputStream fileInputStream = new FileInputStream(FoodImage);
        byte [] img = new byte[fileInputStream.available()];
        fileInputStream.read(img);
    values.put("Food_Name", Foodname);
    values.put("Food_Price", price);
    values.put("Food_Description", Fooddesc);
    values.put("Food_Image", img);
    values.put("RI", ri);


    db.update("Food", values, "Food_Name=?", new String[]{originalfood});
    db.close();}
    catch (IOException e){
        e.printStackTrace();
    }

}
//"("+"Commande_ID"+"INTEGER PRIMARY KEY AUTOINCREMENT,"+
//            "Commande_Name"+"Text,"+
//            "Adress"+"Text,"+
//            "RI"+"INTEGER,"+
//            "FI"+"INTEGER,"+
//            "Amount"+"INTEGER,"+
//            "Date"+"DATETIME,"+
//            "FOREIGN KEY ("+"FI"+") REFERENCES "+"Food"+" ("+"Food_ID"+"),"+
//            "FOREIGN KEY ("+"RI"+") REFERENCES "+"Resto"+" ("+"Resto_ID"+"));";
    //c1
    public void addCommande(String Commande_Name,String Adress,int ri, int fi, int Amount, String date) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("Commande_Name", Commande_Name);
        values.put("Adress", Adress);
        values.put("RI", ri);
        values.put("FI", fi);
        values.put("Amount", Amount);
        values.put("Date", date);


        db.insert("Commande", null, values);
        db.close();
    }
    //c2
    public ArrayList<Commande> readCommande() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor Cursor = db.rawQuery("SELECT * FROM " + "Commande", null);

        ArrayList<Commande> CommandeArrayList = new ArrayList<>();

        if (Cursor.moveToFirst()) {
            do {
                CommandeArrayList.add(new Commande(Cursor.getString(1),
                        Cursor.getString(2),
                        Cursor.getInt(3),
                        Cursor.getInt(4),
                        Cursor.getInt(5),
                        Cursor.getString(6)));
            } while (Cursor.moveToNext());
        }

        Cursor.close();
        return CommandeArrayList;
    }
    //c3
    public void deleteCommande(String Commande) {


        SQLiteDatabase db = this.getWritableDatabase();


        db.delete("Commande", "Commande_Name=?", new String[]{Commande});
        db.close();
    }
    //c4
    public void updateCommande(String originalCommande, String CommandeName,String A, int ri,
                            int fi, int amount,String date) {


        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();


        values.put("Commande_Name", CommandeName);
        values.put("Adress", A);
        values.put("RI", ri);
        values.put("FI", fi);
        values.put("Amount", amount);
        values.put("Date", date);


        db.update("Commande", values, "Commande_Name=?", new String[]{originalCommande});
        db.close();
    }

}
