package com.example.navigationdrawersample.custom

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.example.navigationdrawersample.R
import com.example.navigationdrawersample.data.model.ItemNavigation
import kotlinx.android.synthetic.main.item_destination.view.image_icon
import kotlinx.android.synthetic.main.item_destination.view.text_content_des
import kotlinx.android.synthetic.main.item_destination.view.text_description

class NavigationAdapter(
    private val items: List<ItemNavigation>,
    @NonNull private val onItemClick: (item: ItemNavigation) -> Unit
) :
    RecyclerView.Adapter<NavigationAdapter.NavigationViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NavigationViewHolder {
        return NavigationViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_destination,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return if (items.isNullOrEmpty()) 0 else items.size
    }

    override fun onBindViewHolder(holder: NavigationViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class NavigationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: ItemNavigation) {
            itemView.run {
                image_icon?.setImageResource(item.icon)
                text_content_des?.text = item.label
                text_description.text = item.description

                setOnClickListener { onItemClick(item) }
            }
        }
    }
}
