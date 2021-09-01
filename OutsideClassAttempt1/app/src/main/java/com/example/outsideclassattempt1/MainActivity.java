package com.example.outsideclassattempt1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.os.Bundle;
import android.webkit.WebView;
//import Webview;


public class MainActivity extends AppCompatActivity {
    WebView wv;
    String [] URLs={"https://www.washingtonpost.com","https://www.nytimes.com",
            "https://www.reddit.com", "https://www.cnusports.com/"};
    int url_number = 0; //start with first string
    private void load_next_page() {
        wv.loadUrl(URLs[url_number]);
        url_number=(url_number+1)%URLs.length;
    }
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        //get a handle to the widget in the UI
        wv=(WebView)findViewById(R.id.wv);


        //go to the first pag

    }
    public void doClick(View view) {
        load_next_page();
    }
}