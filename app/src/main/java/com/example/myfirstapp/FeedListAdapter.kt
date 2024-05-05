package com.example.myfirstapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myfirstapp.databinding.ItemFeedsBinding

class FeedListAdapter(
    private var context: Context,
    private val mData: MutableList<ModeList>
) :
    RecyclerView.Adapter<FeedListAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = DataBindingUtil.inflate<ItemFeedsBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_feeds,
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(mData[position], context)
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    inner class MyViewHolder internal constructor(private val binding: ItemFeedsBinding) :
        RecyclerView.ViewHolder(
            binding.root
        ) {
        fun bind(item: ModeList?, context: Context) {
            binding.item = item
            binding.executePendingBindings()
        }
    }
}