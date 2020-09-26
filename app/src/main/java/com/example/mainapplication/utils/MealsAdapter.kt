package com.example.mainapplication.utils

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mainapplication.R
import com.example.mainapplication.core.MealModel

class MealsAdapter(
    private var list: List<MealModel>
): RecyclerView.Adapter<MealsAdapter.MealViewHolder>() {

    private var listener: ClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MealViewHolder(
            parent.context,
            LayoutInflater.from(parent.context).inflate(R.layout.activity_meal_row, parent, false)
        )

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: MealViewHolder, position: Int) {
        holder.bind(list[position], listener)
    }

    fun updateData(data: List<MealModel>?) {
        data?.let {
            list = data
            notifyDataSetChanged()
        }
    }

    fun setListener(listener: ClickListener) {
        this.listener = listener
    }

    inner class MealViewHolder(private val context: Context, view: View) : RecyclerView.ViewHolder(view) {

        @SuppressLint("SetTextI18n")
        fun bind(model: MealModel, listener: ClickListener?) {
            itemView.findViewById<TextView>(R.id.textName).apply {
                text = "Name: ${model.strMeal}"
            }
            itemView.findViewById<TextView>(R.id.textCategory).apply {
                text = "Category: ${model.strCategory}"
            }
            Glide.with(context).load(model.strMealThumb).into(itemView.findViewById(R.id.imageMeal))
            itemView.setOnClickListener {
                listener?.onClickItem(model.idMeal)
            }
        }
    }
}