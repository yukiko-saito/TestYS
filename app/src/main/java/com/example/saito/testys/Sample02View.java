package com.example.saito.testys;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by saito on 2018/11/19.
 */

public class Sample02View extends View{
    public Sample02View(Context context) {
        super(context);
        setBackgroundColor(Color.LTGRAY);
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
    }
}

