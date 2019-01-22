package com.example.saito.testys

import android.content.ClipData
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.ActionBar
import com.example.saito.testys.fragment.LocationDetailsFragment
import com.example.saito.testys.model.ItemData
import com.example.saito.testys.ui.spotdetails.SpotDetailsFragment

class LocationDetailsActivity : AppCompatActivity() {

    companion object {
        val LocationData = "locationData"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.spot_details_activity)
        var str1 : String?= "test1"
        var str2 : String?= "test2"
        val data = intent.getSerializableExtra(LocationData)
        if( data is ItemData){
            str1 = data.title
            str2 = data.detail
        }
        this.supportActionBar?.title = "詳細"
        if (savedInstanceState == null) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.add(R.id.LocationDetailsContainer, LocationDetailsFragment.newInstance(str1!!, str2!!))
            transaction.commit()
        }
    }

}
