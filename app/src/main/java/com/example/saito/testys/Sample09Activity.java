package com.example.saito.testys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Adapter;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import com.example.saito.testys.model.RowData;
import com.example.saito.testys.viewholder.Sample09ViewHolder;
import com.example.saito.testys.adapter.Sample09RecyclerViewAdapter;


public class Sample09Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample09);

        RecyclerView rv = findViewById(R.id.Sample09RecyclerView);
        Sample09RecyclerViewAdapter adapter = new Sample09RecyclerViewAdapter(this.createDataset());
        rv.setAdapter(adapter);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);

        rv.setHasFixedSize(true);




    }

    private List<RowData> createDataset() {

        List<RowData> dataset = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            RowData data = new RowData();
            data.setTitle("羊が" + i + "匹");
            data.setDetail("子羊が" + i + "匹");

            dataset.add(data);
        }
        return dataset;
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
