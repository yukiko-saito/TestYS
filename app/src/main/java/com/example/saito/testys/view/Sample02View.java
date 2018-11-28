package com.example.saito.testys.view;


import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

import com.example.saito.testys.R;

/**
 * Created by saito on 2018/11/19.
 */

public class Sample02View extends View{
    private Bitmap image;

    public Sample02View(Context context) {
        super(context);
        setBackgroundColor(Color.LTGRAY);

        // 画像ファイルの読み込み、あらかじめdrawableにフォルダを作って入れておく
        Resources r = context.getResources();
        image = BitmapFactory.decodeResource(r, R.drawable.illust_bear);

    }

    @Override
    protected void onDraw(Canvas canvas){
        // 描画オブジェクト作成
        Paint paint = new Paint();
        paint.setAntiAlias(true);

        // 文字の描画
        paint.setTextSize(48);
        paint.setColor(Color.rgb(0,0,0));

        canvas.drawText("画面サイズ：" + getWidth() + "x" + getHeight(), 100, 60, paint);

        // 線の描画
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setColor(Color.argb(255,255,0,0));
        canvas.drawLine(50,10,50,90,paint);

        // そのまま表示
        canvas.drawBitmap(image, 0,200, null);

        // ２倍にして表示
        int w = image.getWidth();
        int h = image.getHeight();
        Rect src = new Rect(0,0,w,h);
        Rect dest = new Rect(0,500,w*2,500+h*2);
        canvas.drawBitmap(image, src,dest,null);


    }
}

