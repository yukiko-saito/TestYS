package com.example.saito.testys.ui.spotdetails

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.saito.testys.R

class SpotDetailsFragment : Fragment() {

    companion object {
        fun newInstance() = SpotDetailsFragment()
    }

    private lateinit var viewModel: SpotDetailsViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.spot_details_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SpotDetailsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
