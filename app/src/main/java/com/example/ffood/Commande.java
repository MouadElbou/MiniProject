package com.example.ffood;

public class Commande {
    //"RI"+"INTEGER,"+
    //            "FI"+"INTEGER,"+
    //            "Amount"+"INTEGER,"+
    //            "Date"+"DATETIME,"+
    private  String Cn;
    private  String A;

    private int RI;
    private int FI;
    private int Amount;
    private String Date;
    private int CommandeID;

    public String getA() {
        return A;
    }

    public void setA(String a ) {this.A = a;}

    public String getCn() {
        return Cn;
    }

    public void setCn(String c) {this.Cn = c;}

    public int getRI() {
        return RI;
    }

    public void setRI(int ri) {
        this.RI = ri;
    }

    public int getFI() {
        return FI;
    }

    public void setFI(int fi) {
        this.FI = fi;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        this.Amount = amount;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {this.Date = date;}

    public int getRestoID() {
        return CommandeID;
    }

    public void setRestoID(int CID) {
        this.CommandeID = CID;
    }

    // constructor
    public Commande(String c,String a ,int ri, int fi, int amo, String date) {
        this.A=a;
        this.Cn=c;
        this.RI = ri;
        this.FI = fi;
        this.Amount = amo;
        this.Date = date;
    }
}
