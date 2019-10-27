package com.example.auditable;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CourseInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_info);
        Intent myIntent = getIntent();
        Toast.makeText(this, myIntent.getStringExtra("courseName"), Toast.LENGTH_SHORT).show();


    }
}
