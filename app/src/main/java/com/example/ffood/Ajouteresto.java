package com.example.ffood;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Ajouteresto extends AppCompatActivity {

    // creating variables for our edittext, button and dbhandler
    private EditText courseNameEdt, courseTracksEdt, courseDurationEdt, courseDescriptionEdt;
    private Button addCourseBtn;
    private database dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initializing all our variables.
        View v = getLayoutInflater().inflate(R.layout.ajouteresto,null);
        courseNameEdt = v.findViewById(R.id.idEdtCourseName);
        courseTracksEdt = v.findViewById(R.id.idEdtCourseTracks);
        courseDurationEdt = v.findViewById(R.id.idEdtCourseDuration);
        courseDescriptionEdt = v.findViewById(R.id.idEdtCourseDescription);
        addCourseBtn = v.findViewById(R.id.BtnAdd);

        // creating a new dbhandler class
        // and passing our context to it.
        dbHandler = new database(this);

        // below line is to add on click listener for our add course button.
        addCourseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // below line is to get data from all edit text fields.
                String courseName = courseNameEdt.getText().toString();
                String courseTracks = courseTracksEdt.getText().toString();
                String courseDuration = courseDurationEdt.getText().toString();
                String courseDescription = courseDescriptionEdt.getText().toString();

                // validating if the text fields are empty or not.
                if (courseName.isEmpty() && courseTracks.isEmpty() && courseDuration.isEmpty() && courseDescription.isEmpty()) {
                    Toast.makeText(Ajouteresto.this, "Please enter all the data..",Toast.LENGTH_LONG).show();
                    return;
                }

                // on below line we are calling a method to add new
                // course to sqlite data and pass all our values to it.
                dbHandler.addResto(courseName, courseDuration, courseDescription, courseTracks);

                // after adding the data we are displaying a toast message.
                Toast.makeText(Ajouteresto.this, "Course has been added.", Toast.LENGTH_SHORT).show();
                courseNameEdt.setText("");
                courseDurationEdt.setText("");
                courseTracksEdt.setText("");
                courseDescriptionEdt.setText("");
                Intent intent = new Intent(Ajouteresto.this,HomeFragment.class);

            }
        });
    }
}
