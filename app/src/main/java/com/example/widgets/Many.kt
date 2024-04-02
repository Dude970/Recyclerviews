package com.example.widgets

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class Many(private val items: List<MyItem>, private val onItemClick: (String) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    // Define view types
    private val VIEW_TYPE_ONE = 1
    private val VIEW_TYPE_TWO = 2
    private val VIEW_TYPE_THREE = 3

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_ONE -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_layout_one, parent, false)
                ViewHolderOne(view)
            }

            VIEW_TYPE_TWO -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_layout_two, parent, false)
                ViewHolderTwo(view)
            }

            VIEW_TYPE_THREE -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_layout_three, parent, false)
                ViewHolderThree(view)
            }

            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]
        when (holder.itemViewType) {
            VIEW_TYPE_ONE -> {
                val viewHolderOne = holder as ViewHolderOne
                holder.imageView.setImageResource(R.drawable.img_albumart)
                viewHolderOne.itemView.setOnClickListener {
                    showToast(it.context,"Item layout one clicked")

                }
            }

            VIEW_TYPE_TWO -> {
                val viewHolderTwo = holder as ViewHolderTwo
                holder.imageView.setImageResource(R.drawable.img_detroit_lions_rect)

                viewHolderTwo.itemView.setOnClickListener {
                    showToast(it.context,"Item layout two clicked")

                }

            }

            VIEW_TYPE_THREE -> {
                val viewHolderThree = holder as ViewHolderThree
                holder.imageView.setImageResource(R.drawable.img_new_england_patroit_rect)
                viewHolderThree.itemView.setOnClickListener {
                    showToast(it.context,"Item layout three clicked")
                }

            }
        }
    }

    private fun showToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        val item = items[position]
        // Return the view type based on the item
        return when (item.type) {
            MyItemType.TYPE_ONE -> VIEW_TYPE_ONE
            MyItemType.TYPE_TWO -> VIEW_TYPE_TWO
            MyItemType.TYPE_THREE -> VIEW_TYPE_THREE
        }
    }

    // Define ViewHolder classes for each view type
    inner class ViewHolderOne(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val button: TextView = itemView.findViewById(R.id.onebtn)
        val imageView: ImageView = itemView.findViewById(R.id.imageview)
        init {
            val colorStateList = ContextCompat.getColorStateList(itemView.context, R.color.pp_selector)
            button.setTextColor(colorStateList)
        }
    }
        inner class ViewHolderTwo(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val button: TextView = itemView.findViewById(R.id.twobtn)
            val imageView: ImageView = itemView.findViewById(R.id.imageview)

            init {
                val colorStateList = ContextCompat.getColorStateList(itemView.context, R.color.sc_selector)
                button.setTextColor(colorStateList)
            }
        }

        inner class ViewHolderThree(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val button: TextView = itemView.findViewById(R.id.threebtn)
            val imageView: ImageView = itemView.findViewById(R.id.imageview)

            init {
                val colorStateList = ContextCompat.getColorStateList(itemView.context, R.color.pp_selector)
                button.setTextColor(colorStateList)
            }
        }
    }

    // Define data class for RecyclerView items
    data class MyItem(val type: MyItemType,val text: String, val img:Int)

    // Define enum for item types
    enum class MyItemType {
        TYPE_ONE,
        TYPE_TWO,
        TYPE_THREE
    }

