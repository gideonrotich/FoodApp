package com.example.meals.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.meals.databinding.MealItemBinding
import com.example.meals.domain.models.Meals

class MealAdapter: RecyclerView.Adapter<MealAdapter.MyViewHolder>() {

    private var listener : ((Meals)-> Unit)? = null

    var list = mutableListOf<Meals>()

    fun setContentList(list : MutableList<Meals>){
        this.list = list
        notifyDataSetChanged()
    }

    class MyViewHolder(val viewHolder : MealItemBinding):
    RecyclerView.ViewHolder(viewHolder.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):MealAdapter.MyViewHolder {
        val binding =
            MealItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }
    fun itemClickListener(l:(Meals)->Unit){
        listener= l
    }
    override fun onBindViewHolder(holder: MealAdapter.MyViewHolder, position: Int) {
        holder.viewHolder.meals = this.list[position]
        holder.viewHolder.root.setOnClickListener {
            listener?.let {
                it(this.list[position])
            }
        }

    }
    override fun getItemCount(): Int {
        return this.list.size
    }
}