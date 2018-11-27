package com.example.saito.testys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
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

    @Override
    // キー操作
    // onKeyDownはboolなのでなんらかのbool結果を返す必要がある
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if (keyCode == KeyEvent.KEYCODE_BACK) { // 戻るボタンをタップ
            this.finish();      // このActivityを終了させる
            return true;
        }
        return false;
    }

}

