package com.example.saito.testys.adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.saito.testys.R;
import com.example.saito.testys.ViewPagerActivity;
import com.example.saito.testys.model.RowData;

import java.util.List;

/**
 * Created by saito on 2018/11/28.
 */

public class Sample10PagerAdapter extends PagerAdapter {

    public List<RowData> items;

    public Sample10PagerAdapter(List<RowData> list) {this.items = list;}

    private final static int WC = LinearLayout.LayoutParams.WRAP_CONTENT;

    @Override
    public int getCount(){return items.size();}

    @Override
    @NonNull
    public Object instantiateItem(ViewGroup container, int pos){
        Context context = container.getContext();
        RowData item = items.get(pos);

        LinearLayout layout = new LinearLayout(context);

        layout.setBackgroundColor(Color.WHITE);
        layout.setPadding(10,10,10,10);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setGravity(Gravity.CENTER);

        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(120, 120));
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.illust_bear);
        imageView.setImageBitmap(bitmap);
        layout.addView(imageView);

        TextView textView = new TextView(context);
        textView.setTextColor(Color.RED);
        textView.setText(item.getTitle());
        textView.setLayoutParams(new LinearLayout.LayoutParams(WC,WC));
        layout.addView(textView);

        container.addView(layout);
        return layout;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object view){
        container.removeView((View)view);
    }

    @Override
    public boolean isViewFromObject(View view, Object object){
        return view == (LinearLayout)object;
    }
}
