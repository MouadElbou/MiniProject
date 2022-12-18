package com.example.ffood;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;


public class mf extends AppCompatActivity {
    //;
    //    private String ;
    //    private String ;
    //    private String ;
    database db;
    String rn,ar,nr,er;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mf);

        List<RestoClass> challenge = this.getIntent().getExtras().getParcelableArrayList("resto");


// Retrieve the extras
        rn = challenge.get(1).toString();
        ar = challenge.get(2).toString();
        nr = challenge.get(3).toString();
        er = challenge.get(4).toString();

// Get a reference to the EditText view
        EditText editText = findViewById(R.id.RestoName);
        EditText editText1 = findViewById(R.id.AdressResto);
        EditText editText2 = findViewById(R.id.NumeroResto);
        EditText editText3 = findViewById(R.id.EmailResto);
        Button btn1 = findViewById(R.id.Btnsup);
        Button    btn2=findViewById(R.id.btnup);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.updateresto(rn,editText.getText().toString(),editText1.getText().toString(),editText2.getText().toString(),editText3.getText().toString());
                Toast.makeText(mf.this, "Resto Updated..", Toast.LENGTH_SHORT).show();

                // launching our main activity.
                Intent i = new Intent(mf.this, HomeFragment.class);
                startActivity(i);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.deleteResto(rn);
                Toast.makeText(mf.this, "Deleted the Resto", Toast.LENGTH_SHORT).show();

                // launching our main activity.
                Intent i = new Intent(mf.this, HomeFragment.class);
                startActivity(i);
            }
        });
// Set the text of the EditText view
        editText.setText(rn);
        editText1.setText(ar);
        editText2.setText(nr);
        editText3.setText(er);
    }


}
