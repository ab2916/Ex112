package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int count = 0;

    EditText et;
    static final String COUNT_KEY = "count";
    static final String STRING_KEY = "string";

    SharedPreferences settings;
    TextView outputText;
    String str;
    int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = findViewById(R.id.input_field);
        outputText = findViewById(R.id.output_text);
        str = "";
        count = 0;
        settings=getSharedPreferences("PREFS_NAME",MODE_PRIVATE);
        count = settings.getInt(COUNT_KEY, 0);
        outputText.setText(Integer.toString(count));
        str = settings.getString(STRING_KEY,"");
        et.setText(str);
    }
    public void count(View view) {
        count++;
        outputText.setText(Integer.toString(count));
    }

    public void reset(View view) {
        count = 0;
        outputText.setText(Integer.toString(count));
    }

    public void exit(View view) {
        str = et.getText().toString();
        //settings=getSharedPreferences("PREFS_NAME",MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt(COUNT_KEY, count);
        editor.putString(STRING_KEY, str);
        editor.commit();
        finish();
    }
}