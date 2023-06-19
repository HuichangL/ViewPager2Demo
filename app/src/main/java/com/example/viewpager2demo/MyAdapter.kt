package com.example.viewpager2demo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.viewpager2demo.databinding.ItemViewBinding

class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    inner class MyViewHolder(private val binding: ItemViewBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindData(data: String) {
            binding.textView.text = data
        }
    }


    // 在这里定义你的数据源
    private val dataList: MutableList<String> = mutableListOf()

    // 添加数据到数据源
    fun setData(data: List<String>) {
        dataList.clear()
        dataList.addAll(data)
        notifyDataSetChanged()
    }

    // 创建ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(view)
    }

    // 绑定数据到ViewHolder
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = dataList[position]
        holder.bindData(data)
    }

    // 返回数据源的大小
    override fun getItemCount(): Int {
        return dataList.size
    }
}