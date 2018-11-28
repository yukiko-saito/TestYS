package com.example.saito.testys;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.saito.testys.model.RowData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by saito on 2018/11/27.
 */

public class Sample10Activity extends AppCompatActivity implements View.OnClickListener{
    private final static int WC = LinearLayout.LayoutParams.WRAP_CONTENT;

    private final static String TAG_GRIDVIEW = "gridview";
    private final static String TAG_VIEWPAGER = "viewpager";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setBackgroundColor(Color.WHITE);
        layout.setOrientation(LinearLayout.VERTICAL);
        setContentView(layout);

        layout.addView(makeButton("グリッドビュー", TAG_GRIDVIEW));
        layout.addView(makeButton("ビューページャー", TAG_VIEWPAGER));

    }

    private Button makeButton(String text, String tag){
        Button button = new Button(this);
        button.setText(text);
        button.setTag(tag);
        button.setOnClickListener(this);
        button.setLayoutParams(new LinearLayout.LayoutParams(WC,WC));

        return button;
    }

    public void onClick(View v){
        String tag = (String)v.getTag();
        if(TAG_GRIDVIEW.equals(tag)){
            Intent intent = new Intent(this, GridViewActivity.class);
            startActivity(intent);
        } else if( TAG_VIEWPAGER.equals(tag)){
            Intent intent = new Intent(this, ViewPagerActivity.class);
            startActivity(intent);
        }
    }

    /*
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
    */
}
