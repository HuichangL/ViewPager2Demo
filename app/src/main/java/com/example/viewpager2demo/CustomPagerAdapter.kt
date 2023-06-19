package com.example.viewpager2demo

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.viewpager2demo.databinding.ItemViewBinding


class CustomPagerAdapter() :
    RecyclerView.Adapter<CustomPagerAdapter.ViewHolder>() {

    companion object {
        const val TAG = "CustomPagerAdapter"
    }

    // 在这里定义你的数据源
    private val dataList: MutableList<String> = mutableListOf()

    // 添加数据到数据源
    fun setData(data: List<String>) {
        dataList.clear()
        dataList.addAll(data)
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemViewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: String) {
            // 绑定数据到视图
            binding.textView.text = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.d(TAG, "onCreateViewHolder: Creating new page")
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemViewBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d(TAG, "onBindViewHolder: Binding page at position $position")
        val item = dataList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}
