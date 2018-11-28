package com.example.saito.testys;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.GridView;

import com.example.saito.testys.adapter.Sample10PagerAdapter;
import com.example.saito.testys.model.RowData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by saito on 2018/11/28.
 */

public class ViewPagerActivity extends Activity {
    private List<RowData> items;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ViewPager viewPager = new ViewPager(this);
        viewPager.setAdapter(new Sample10PagerAdapter(this.createDataset()));
        setContentView(viewPager);

    }

    private List<RowData> createDataset() {

        List<RowData> dataset = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            RowData data = new RowData();
            data.setTitle("熊が" + i + "頭");
            data.setDetail("子熊" +"が" + i + "頭");

            dataset.add(data);
        }
        return dataset;
    }
}
