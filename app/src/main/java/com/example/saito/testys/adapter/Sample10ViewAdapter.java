package com.example.saito.testys.adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.Image;
import android.provider.ContactsContract;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.saito.testys.GridViewActivity;
import com.example.saito.testys.R;
import com.example.saito.testys.model.RowData;

import java.util.List;

/**
 * Created by saito on 2018/11/28.
 */

public class Sample10ViewAdapter extends BaseAdapter {

    public List<RowData> items;

    public Sample10ViewAdapter(List<RowData> list) {this.items = list;}

    private final int WC = LinearLayout.LayoutParams.WRAP_CONTENT;

    @Override
    public int getCount(){return items.size();}
    @Override
    public Object getItem( int pos ){return items.get(pos);}
    @Override
    public long getItemId(int pos){return pos;}

    @Override
    public View getView(int pos, View view, ViewGroup parent){
        Context context = parent.getContext();
        RowData item = items.get(pos);

        // １アイテム分のレイアウトを作っている
        if( view == null ){
            LinearLayout layout = new LinearLayout(context);
            layout.setBackgroundColor(Color.WHITE);
            layout.setPadding(10,10,10,10);
            layout.setOrientation(LinearLayout.VERTICAL);
            layout.setGravity(Gravity.CENTER);
            view = layout;

            ImageView imageView = new ImageView(context);
            imageView.setTag("icon");
            imageView.setLayoutParams(new LinearLayout.LayoutParams(120, 120));
            layout.addView(imageView);

            TextView textView = new TextView(context);
            textView.setTag("title");
            textView.setTextColor(Color.BLUE);
            textView.setGravity(Gravity.CENTER);
            layout.addView(textView);
        }

        // 値のはめ込み
        ImageView imageView= (ImageView)view.findViewWithTag("icon");
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.illust_bear);
        imageView.setImageBitmap(bitmap);
        TextView textView = (TextView)view.findViewWithTag("title");
        textView.setText(item.getTitle());

        return view;

    }
}
