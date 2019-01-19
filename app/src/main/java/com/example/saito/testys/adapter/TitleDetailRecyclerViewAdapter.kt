package com.example.saito.testys.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import com.example.saito.testys.R
import com.example.saito.testys.viewholder.Sample09ViewHolder
import com.example.saito.testys.viewholder.TitleDetailViewHolder
import android.content.ClipData.Item
import android.databinding.DataBindingUtil
import com.example.saito.testys.databinding.TitledetailrowBinding
import com.example.saito.testys.model.ItemData


/**
 * Created by saito on 2018/11/27.
 */

class TitleDetailRecyclerViewAdapter(var list: List<ItemData>) : RecyclerView.Adapter<TitleDetailRecyclerViewAdapter.BindingViewHolder>() {
    lateinit var listener: OnItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BindingViewHolder? {
        setOnItemClickListener(listener)
        val layoutInflater = LayoutInflater.from(parent!!.context)
        val binding = TitledetailrowBinding.inflate(layoutInflater, parent, false)
        return BindingViewHolder(binding)

    }

    override fun onBindViewHolder(holder: BindingViewHolder, position: Int) {
        val data = list[position]
        holder.binding.item = data  // layoutファイルのbinding data "item"にデータをセットする（setItem)
        holder.binding.itemLayout.setOnClickListener {
            listener.onClick(it, data)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface OnItemClickListener {
        fun onClick(view: View, data: ItemData)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }


    class BindingViewHolder(var binding: TitledetailrowBinding) : RecyclerView.ViewHolder(binding.root)
}
