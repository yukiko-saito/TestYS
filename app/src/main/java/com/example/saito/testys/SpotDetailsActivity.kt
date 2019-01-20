package com.example.saito.testys

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.ActionBar
import com.example.saito.testys.ui.spotdetails.SpotDetailsFragment

class SpotDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.spot_details_activity)
        this.supportActionBar?.title = "詳細"
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, SpotDetailsFragment.newInstance())
                    .commitNow()
        }
    }

}
