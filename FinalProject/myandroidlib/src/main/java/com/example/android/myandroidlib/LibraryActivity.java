package com.example.android.myandroidlib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class LibraryActivity extends AppCompatActivity {

        private TextView mJokeTextView;
        private String myJoke = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        mJokeTextView = (TextView) findViewById(R.id.textView);
        if(getIntent() !=null)
        myJoke = getIntent().getStringExtra("JokeText");
        mJokeTextView.setText(myJoke);
    }
}
