package com.example.saito.testys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class Sample07Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WebView webView = new WebView(this);
        webView.setWebViewClient(new WebViewClient());

        setContentView(webView);

        webView.loadUrl("http://www.aizulab.com/");

    }

    private void toast(String text){
        if( text == null ) text = "";
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }
}

