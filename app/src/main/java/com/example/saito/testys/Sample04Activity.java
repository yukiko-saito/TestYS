package com.example.saito.testys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

/**
 * Created by saito on 2018/11/20.
 */

public class Sample04Activity extends AppCompatActivity{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new Sample04View(this));
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
