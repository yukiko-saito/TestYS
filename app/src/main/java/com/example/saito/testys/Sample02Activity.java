package com.example.saito.testys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;

public class Sample02Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new Sample02View(this));
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
