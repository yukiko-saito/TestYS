package com.example.saito.testys

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class Sample13Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample13)

        // ActionBarのタイトルを変更
        this.supportActionBar?.title = resources.getResourceName(R.string.top_title)
    }
}
