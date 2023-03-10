package com.nise.paste.UI.View

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.nise.paste.Data.DTO.Todos
import com.nise.paste.databinding.ItemBinding

class Adapter : RecyclerView.Adapter<ViewHolder>(){
    /*var list = arrayListOf<Todos>()

    private lateinit var binding: ItemBinding
    inner class MyViewHolder(binding:ItemBinding):ViewHolder(binding.root){
        fun bind(data: Todos){
            binding.content.text = data.content

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var layoutInflater = LayoutInflater.from(parent.context)
        binding = ItemBinding.inflate(layoutInflater,parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if(holder is MyViewHolder)
            holder.bind(list[position])
    }

    override fun getItemCount()=list.size

    fun setList(input_list:List<Todos>){
        list.addAll(input_list)
    }*/

    var list = arrayListOf<Todos>()

    private lateinit var binding:ItemBinding
    /** 아이템을 넣을 커스텀 뷰홀더*/
    inner class MyViewHolder(binding: ItemBinding):ViewHolder(binding.root){
        fun bind(data: Todos){
            binding.content.text = data.content
            binding.deadline.text = data.deadline
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var layoutInflater = LayoutInflater.from(parent.context)
        binding = ItemBinding.inflate(layoutInflater,parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if(holder is MyViewHolder) holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setList(input_list:List<Todos>){
        list.addAll(input_list)
    }
}