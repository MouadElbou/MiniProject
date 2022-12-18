package com.example.ffood;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText username;
    EditText password;
    Button loginButton;
    database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);
        db = new database(this);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               String use = username.getText().toString();
               String pass = password.getText().toString();
                if(TextUtils.isEmpty(use) || TextUtils.isEmpty(pass)){
                    Toast.makeText(MainActivity.this,"All filde Required",Toast.LENGTH_LONG).show();
                }else{
                    Boolean checkusernamepass = db.checkusernamepass(use,pass);
                    if(checkusernamepass == true){
                        Toast.makeText(MainActivity.this,"Login Successful",Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getApplicationContext(),menu.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(MainActivity.this,"Login Failed",Toast.LENGTH_LONG).show();
                    }
                }

            }
    });
}
}