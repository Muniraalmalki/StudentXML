package com.example.studentxml

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.studentxml.databinding.ItemRowBinding

class RecyclerViewAdapter(private val students:ArrayList<Students>): RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder>() {
    class ItemViewHolder(val binding:ItemRowBinding): RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return  ItemViewHolder(ItemRowBinding.inflate(LayoutInflater.from(parent.context)
            , parent,
            false))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
      val student = students[position]
        holder.binding.apply {
            tvId.text = student.id.toString()
            tvName.text = student.name
            tvGrade.text = student.grade.toString()
        }
    }

    override fun getItemCount(): Int {
        return students.size
    }
}