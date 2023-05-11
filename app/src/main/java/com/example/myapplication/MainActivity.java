package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * The type Main activity.
 */
public class MainActivity extends AppCompatActivity {
    /**
     * The Count.
     */
    int count = 0;

    /**
     * The Et.
     */
    EditText et;
    /**
     * The Count key.
     */
    static final String COUNT_KEY = "count";
    /**
     * The String key.
     */
    static final String STRING_KEY = "string";

    /**
     * The Settings.
     */
    SharedPreferences settings;
    /**
     * The Output text.
     */
    TextView outputText;
    /**
     * The Str.
     */
    String str;
    /**
     * The Num.
     */
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

    /**
     * Count.
     *
     * @param view the view
     */
    public void count(View view) {
        count++;
        outputText.setText(Integer.toString(count));
    }

    /**
     * Reset.
     *
     * @param view the view
     */
    public void reset(View view) {
        count = 0;
        outputText.setText(Integer.toString(count));
    }

    /**
     * Exit.
     *
     * @param view the view
     */
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