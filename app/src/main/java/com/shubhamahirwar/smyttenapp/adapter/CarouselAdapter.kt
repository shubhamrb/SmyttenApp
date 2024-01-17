package com.shubhamahirwar.smyttenapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.shubhamahirwar.smyttenapp.R
import com.shubhamahirwar.smyttenapp.models.Data
import com.shubhamahirwar.smyttenapp.ui.ActivityA
import com.shubhamahirwar.smyttenapp.ui.ActivityB
import com.shubhamahirwar.smyttenapp.ui.ActivityC
import com.shubhamahirwar.smyttenapp.ui.ActivityD
import com.shubhamahirwar.smyttenapp.ui.ActivityE
import com.shubhamahirwar.smyttenapp.ui.ActivityF

class CarouselAdapter(
    private var context: Context,
    private val type: String,
    private val productList: List<Data>
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val TYPE_PRODUCT = 0
        private const val TYPE_BUTTON = 1
    }


    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productImage: ImageView = itemView.findViewById(R.id.productImage)
        val brandAndProductName: TextView = itemView.findViewById(R.id.brandAndProductName)
        val addToCartButton: Button = itemView.findViewById(R.id.addToCartButton)
    }

    inner class ButtonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val goToActivityButton: Button = itemView.findViewById(R.id.goToActivityButton)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_PRODUCT -> {
                val itemView = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_product, parent, false)
                ProductViewHolder(itemView)
            }

            TYPE_BUTTON -> {
                val itemView = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_button, parent, false)
                ButtonViewHolder(itemView)
            }

            else -> throw IllegalArgumentException("Unknown view type: $viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val product = productList[position]

        when (holder) {
            is ProductViewHolder -> {
                Glide.with(context).load(product.image).into(holder.productImage)
                holder.brandAndProductName.text = product.brand + "-" + product.name
                holder.addToCartButton.setOnClickListener {
                    holder.addToCartButton.text = "In cart"
                }
            }

            is ButtonViewHolder -> {
                holder.goToActivityButton.text = product.name
                holder.goToActivityButton.setOnClickListener {
                    when (product.id) {
                        1 -> {
                            context.startActivity(
                                Intent(
                                    context,
                                    ActivityA::class.java
                                ).putExtra("name", product.name)
                            )
                        }

                        2 -> {
                            context.startActivity(
                                Intent(
                                    context,
                                    ActivityB::class.java
                                ).putExtra("name", product.name)
                            )
                        }

                        3 -> {
                            context.startActivity(
                                Intent(
                                    context,
                                    ActivityC::class.java
                                ).putExtra("name", product.name)
                            )
                        }

                        4 -> {
                            context.startActivity(
                                Intent(
                                    context,
                                    ActivityD::class.java
                                ).putExtra("name", product.name)
                            )
                        }

                        5 -> {
                            context.startActivity(
                                Intent(
                                    context,
                                    ActivityE::class.java
                                ).putExtra("name", product.name)
                            )
                        }

                        6 -> {
                            context.startActivity(
                                Intent(
                                    context,
                                    ActivityF::class.java
                                ).putExtra("name", product.name)
                            )
                        }

                    }
                }
            }
        }
    }

    override fun getItemCount() = productList.size

    override fun getItemViewType(position: Int): Int {
        return if (type == "PRODUCT") {
            TYPE_PRODUCT
        } else {
            TYPE_BUTTON
        }
    }
}
