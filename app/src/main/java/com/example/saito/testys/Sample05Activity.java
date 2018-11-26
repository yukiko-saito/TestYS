package com.example.saito.testys;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Sample05Activity extends AppCompatActivity {

    private final static int WC = LinearLayout.LayoutParams.WRAP_CONTENT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        setContentView(layout);

        TextView textView = new TextView(this);
        textView.setText("これはテキストビューのテスト");
        textView.setTextSize(16.0f);
        textView.setTextColor(Color.rgb(0,0,255));
        textView.setLayoutParams(new LinearLayout.LayoutParams(WC, WC));

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.illust_bear);

        ImageView imageView = new ImageView(this);
        imageView.setImageBitmap(bitmap);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(WC,WC));

        layout.addView(textView);
        layout.addView(imageView);


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
