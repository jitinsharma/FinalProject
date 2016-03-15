package com.sharma.jitin.jokedisplay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        TextView jokeDisplay = (TextView)findViewById(R.id.jokeDisplay);

        if (getIntent().hasExtra("joke")){
            jokeDisplay.setText(getIntent().getStringExtra("joke"));
        }
    }
}
