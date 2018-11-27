package com.example.saito.testys.viewholder;

import android.view.View;
import android.widget.TextView;
import android.support.v7.widget.RecyclerView;

import com.example.saito.testys.R;

/**
 * Created by saito on 2018/11/27.
 */

public class Sample09ViewHolder extends RecyclerView.ViewHolder {
    public TextView titleView;
    public TextView detailView;

    public Sample09ViewHolder(View itemView) {
        super(itemView);
        titleView = (TextView) itemView.findViewById(R.id.title);
        detailView = (TextView) itemView.findViewById(R.id.detail);

    }
}
