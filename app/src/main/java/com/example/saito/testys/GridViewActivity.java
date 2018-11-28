package com.example.saito.testys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.content.Context;

import com.example.saito.testys.adapter.Sample09RecyclerViewAdapter;
import com.example.saito.testys.adapter.Sample10ViewAdapter;
import com.example.saito.testys.model.RowData;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by saito on 2018/11/27.
 */

public class GridViewActivity extends AppCompatActivity {
    private ArrayList<RowData> items;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        GridView gridView = new GridView(this);
        gridView.setNumColumns(4);
        gridView.setAdapter(new Sample10ViewAdapter(this.createDataset()));
        setContentView(gridView);

    }

    private List<RowData> createDataset() {

        List<RowData> dataset = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            RowData data = new RowData();
            data.setTitle("牛が" + i + "頭");
            data.setDetail("子牛が" + i + "頭");

            dataset.add(data);
        }
        return dataset;
    }

}