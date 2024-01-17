package com.shubhamahirwar.smyttenapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.shubhamahirwar.smyttenapp.R
import com.shubhamahirwar.smyttenapp.models.Content

class HomeVerticalAdapter(private var context: Context) :
    RecyclerView.Adapter<HomeVerticalAdapter.CarouselViewHolder>() {
    private var verticalList: List<Content> = ArrayList()

    inner class CarouselViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val horizontalRecyclerView: RecyclerView =
            itemView.findViewById(R.id.horizontalRecyclerView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarouselViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_vertical, parent, false)
        return CarouselViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CarouselViewHolder, position: Int) {
        val content = verticalList[position]

        val carouselAdapter = CarouselAdapter(context, content.type, content.data)
        holder.horizontalRecyclerView.layoutManager =
            LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        holder.horizontalRecyclerView.adapter = carouselAdapter
    }

    override fun getItemCount() = verticalList.size

    fun setList(content: List<Content>) {
        verticalList = content
        notifyDataSetChanged()
    }
}
