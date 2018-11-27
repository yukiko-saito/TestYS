package com.example.saito.testys.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.saito.testys.R;
import com.example.saito.testys.model.RowData;
import com.example.saito.testys.viewholder.Sample09ViewHolder;

import java.util.List;

/**
 * Created by saito on 2018/11/27.
 */

public class Sample09RecyclerViewAdapter extends RecyclerView.Adapter<Sample09ViewHolder> {

    private List<RowData> list;

    public Sample09RecyclerViewAdapter(List<RowData> list) {
        this.list = list;
    }

    @Override
    @NonNull
    public Sample09ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent,false);
        Sample09ViewHolder vh = new Sample09ViewHolder(inflate);
        return vh;
    }

    @Override
    public void onBindViewHolder(Sample09ViewHolder holder, int position) {
        holder.titleView.setText(list.get(position).getTitle());
        holder.detailView.setText(list.get(position).getDetail());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
