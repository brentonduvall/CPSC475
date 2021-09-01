package com.example.inclassapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


public class MainActivity extends AppCompatActivity {
//    private static final int  = 254;
    private static final String TAG = "Cannot invoke method length() on null object";
    String [] URLs={"https://www.washingtonpost.com","https://www.nytimes.com","https: www.reddit.com"};
    WebView wv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Log.d(TAG, "onCreate: ");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void load_next_page() {
        wv.loadUrl(URLs[url_number]);
        url_number = (url_number + 1) % URLs.length;
    }

    public void doClick(View view) {
        load_next_page();
    }
}

//    WebView wv;

//    int url_number = 0; //start with frst string
//    private void load_next_page() {
//        wv.loadUrl(URLs[url_number]);
//        url_number=(url_number+1)%URLs.length;

