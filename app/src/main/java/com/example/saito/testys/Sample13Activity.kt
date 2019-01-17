package com.example.saito.testys

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.saito.testys.adapter.Sample09RecyclerViewAdapter
import com.example.saito.testys.adapter.TitleDetailRecyclerViewAdapter
import com.example.saito.testys.model.ItemData
import com.example.saito.testys.model.RowData
import java.util.ArrayList

class Sample13Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample13)

        // ActionBarのタイトルを変更
        this.supportActionBar?.title = getString(R.string.top_title)

        val rv = findViewById<RecyclerView>(R.id.TourSpotListRecyclerView)
        val adapter = TitleDetailRecyclerViewAdapter(this.createDataset())
        rv.adapter = adapter

        val llm = LinearLayoutManager(this)
        rv.layoutManager = llm

        rv.setHasFixedSize(true)


    }

    private fun createDataset(): List<ItemData> {

        val dataset = ArrayList<ItemData>()
        for (i in 0..10) {
            val data = ItemData()
            data.title = "羊が" + i + "匹"
            data.detail = "子羊が" + i + "匹"

            dataset.add(data)
        }
        return dataset
    }

}
