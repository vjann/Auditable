package com.example.auditable;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String[] KEYWORDS = new String[] {"Denero", "Hug", "Conelly"};
    private MultiAutoCompleteTextView inputKeywords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputKeywords = findViewById(R.id.keyword_input);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, KEYWORDS);
        inputKeywords.setAdapter(adapter);
        inputKeywords.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());


        Button find_button = (Button) findViewById(R.id.find_button);
        find_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] keywords = getKeywords(view);
                EditText inputted_time = findViewById(R.id.time_input);
                String str = inputted_time.getText().toString();
                DateFormat formatter = new SimpleDateFormat("hh:mm:ss a");
                Date date = null;
                try {
                    date = formatter.parse(str);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                Intent toSettings = new Intent(getApplicationContext(), ResultsActivity.class);
                toSettings.putExtra("KEYWORDS",keywords);
                toSettings.putExtra("TIME", str);

                startActivity(toSettings);
            }
        });

        Button settings_button = (Button) findViewById(R.id.settings_button);
        settings_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toSettings = new Intent(getApplicationContext(), SettingsActivity.class);
                startActivity(toSettings);
            }
        });

    }
    public String[] getKeywords(View view) {
        String input = inputKeywords.getText().toString();
        String[] singleKeywords = input.split("\\s*,\\s*");
        Toast.makeText(this, input, Toast.LENGTH_SHORT).show();
        return singleKeywords;
    }
}
