package com.example.saito.testys.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.GestureDetector;

import java.util.ArrayList;


/**
 * Created by saito on 2018/11/20.
 */

public class Sample04View extends View implements
        GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener
{
    private ArrayList<String> info;
    private  GestureDetector gestureDetector;

    public Sample04View(Context context){
        super(context);
        setBackgroundColor(Color.WHITE);

        info = new ArrayList<String>();
        info.add("GestureEx: ");

        gestureDetector = new GestureDetector(context, this);

    }

    @Override
    protected void onDraw(Canvas canvas){
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setTextSize(48);

        for( int i = 0; i < info.size(); i++){
            canvas.drawText(info.get(i), 0, 60+60*i, paint);
        }
    }

    private void addInfo(String str){
        info.add(1, str);
        while( info.size() > 30) info.remove( info.size() - 1);
        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        gestureDetector.onTouchEvent(event);
        return true;
    }

    public boolean onDown(MotionEvent event){
        addInfo("Down");
        return false;
    }

    public void onShowPress(MotionEvent event){
        addInfo("ShowPress");
    }

    public boolean onSingleTapUp(MotionEvent event){
        addInfo("UP");
        return false;
    }

    public void onLongPress(MotionEvent event){
        addInfo("LongPress");
    }

    public boolean onFling(MotionEvent e0, MotionEvent e1,
                           float velocityX, float velocityY){
        addInfo("Fring(" + (int)velocityX + "," + (int)velocityY + ")");
        return false;
    }

    public boolean onScroll(MotionEvent e0, MotionEvent e1,
                            float velocityX, float velocityY){
        addInfo("Scroll(" + (int)velocityX + "," + (int)velocityY + ")");

        return false;
    }

    public boolean onSingleTapConfirmed(MotionEvent e){
        addInfo("SingleTap");
        return false;
    }

    public boolean onDoubleTap(MotionEvent e){
        addInfo("DoubleTap");
        return false;
    }

    public boolean onDoubleTapEvent(MotionEvent e){
        addInfo("DoubleTapEvent");
        return false;
    }
}
