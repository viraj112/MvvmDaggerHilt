package com.neosoft.mvvm.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.neosoft.mvvm.R
import com.neosoft.mymvvm.model.Data
import kotlinx.android.synthetic.main.item_list_main.view.*

class MyProductListAdapter(val context: Context, val list: List<Data>) :
    RecyclerView.Adapter<MyProductListAdapter.MYViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MYViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_list_main, parent, false)
        return MYViewHolder(view)
    }

    override fun onBindViewHolder(holder: MYViewHolder, position: Int) {
        Glide.with(context).load(list.get(position).product_images)
            .into(holder.itemView.iv_my_items)
        holder.itemView.tv_product_name.text = list.get(position).name
    }

    override fun getItemCount(): Int {
        return list.size
    }
    class MYViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }
}