package com.example.saito.testys.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.example.saito.testys.R


/**
 * Created by saito on 2019/1/15.
 */

class TitleDetailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var titleView: TextView
    var detailView: TextView

    init {
        titleView = itemView.findViewById(R.id.title) as TextView
        detailView = itemView.findViewById(R.id.detail) as TextView

    }
}
