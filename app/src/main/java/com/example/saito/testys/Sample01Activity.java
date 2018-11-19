package com.example.saito.testys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
/**
 * Created by saito on 2018/11/07.
 */

public class Sample01Activity extends AppCompatActivity {

    // onCreateは必須
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // レイアウトファイルのactivity_sample01をviewとしてセットするよ、ってこと。
        setContentView(R.layout.activity_sample01);
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

