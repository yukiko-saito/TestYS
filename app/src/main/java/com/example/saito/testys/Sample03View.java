package com.example.saito.testys;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import java.security.Key;
import java.util.HashMap;

/**
 * Created by saito on 2018/11/19.
 */

public class Sample03View extends View {

    private HashMap<String, PointF> points = new HashMap<String, PointF>();
    private int hcount;

    public Sample03View(Context context){
        super(context);
        setBackgroundColor(Color.WHITE);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setTextSize(48);

        // タッチXY座標の描画
        canvas.drawText("TouchEx: ", 0, 60, paint);
        Object[] keys = points.keySet().toArray();

        for( int i = 0; i < keys.length; i++){
            PointF pos = (PointF)points.get(keys[i]);
            canvas.drawText((int)pos.x + "," + (int)pos.y, 0, 120+60*i, paint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){

        // アクション種別とタッチ数の取得
        int action = event.getAction();
        int count = event.getPointerCount();

        // アクションインデックスとポインタIDの取得
        int index = event.getActionIndex();
        int pointerID = event.getPointerId(index);

        // タッチ位置の取得
        switch( action & MotionEvent.ACTION_MASK){
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_POINTER_DOWN:
                points.put("" + pointerID, new PointF(event.getX(), event.getY()));
                break;
            case MotionEvent.ACTION_MOVE:
                /*
                for( int i=0; i < count; i++){
                    PointF pos = points.get(""+ event.getPointerId(i));
                    pos.x = event.getX();
                    pos.y = event.getY();
                }
                */
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_POINTER_UP:
            case MotionEvent.ACTION_CANCEL:
                points.remove(""+pointerID);
                break;
        }

        invalidate();
        return true;
    }
}
