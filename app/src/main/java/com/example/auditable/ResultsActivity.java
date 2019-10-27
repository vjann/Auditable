package com.example.auditable;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class ResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        ArrayList<String> r1 = new ArrayList<String>();
        r1.add("A");
        r1.add("B");
        r1.add("C");
        r1.add("D");
        r1.add("Class Description/Title1");
        ArrayList<String> r2 = new ArrayList<String>();
        r2.add("A1");
        r2.add("B1");
        r2.add("C1");
        r2.add("D1");
        r2.add("Class Description/Title2");
        ArrayList<String> r3 = new ArrayList<String>();
        r3.add("A2");
        r3.add("B2");
        r3.add("C2");
        r3.add("D2");
        r3.add("Class Description/Title3");
        ArrayList<String> r4 = new ArrayList<String>();
        r4.add("A3");
        r4.add("B3");
        r4.add("C3");
        r4.add("D3");
        r4.add("Class Description/Title4");


        ArrayList<ArrayList<String>> results = new ArrayList<>();
        results.add(r1);
        results.add(r2);
        results.add(r3);
        results.add(r4);

        LinearLayout outer = (LinearLayout) findViewById(R.id.outer_linear_layout);

        List<LinearLayout> coursesList = new ArrayList<LinearLayout>();
        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        p.weight = 1;

        for (int i = 0; i < results.size(); i++) {
            ArrayList<String> strings = results.get(i);
            // For each row, have a 2 element vert. Linear Layout, where top is horiz. Linear Layout containing most info, bottom is description

            LinearLayout middle = new LinearLayout(this);
            coursesList.add(middle);
            middle.setOrientation(LinearLayout.VERTICAL);
            middle.setLayoutParams(p);

            LinearLayout inner = new LinearLayout(this);
            inner.setOrientation(LinearLayout.HORIZONTAL);
            inner.setLayoutParams(p);
            for (int j = 0; j < strings.size() - 1; j++) {
                TextView entry = new TextView(this);
                entry.setText(strings.get(j));
                entry.setLayoutParams(p);
                inner.addView(entry);
            }
            middle.addView(inner);

            //add last element of strings, which is description
            TextView class_description = new TextView(this);
            class_description.setText(strings.get(strings.size() - 1));
            middle.addView(class_description);

            final String courseName = strings.get(0);
            middle.setId(i);
            middle.setClickable(true);
            middle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent myIntent = new Intent(ResultsActivity.this, CourseInfoActivity.class);
                    myIntent.putExtra("courseName", courseName);
                    startActivity(myIntent);
                }
            });

            outer.addView(middle);
        }
        Toast.makeText(this, "ads;lfkjsad;lfj", Toast.LENGTH_SHORT).show();
    }
}
