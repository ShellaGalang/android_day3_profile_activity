package com.example.day2_miniprofile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProfileAdapter(
    private val items: List<ProfileItem>,
    private val onItemClick: (ProfileItem) -> Unit
) : RecyclerView.Adapter<ProfileInfoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileInfoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_basic_info, parent, false)
        return ProfileInfoViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProfileInfoViewHolder, position: Int) {
        val item = items[position]

        holder.title.text = item.title

        holder.itemView.setOnClickListener {
            onItemClick(item)
        }
    }

    override fun getItemCount(): Int = items.size
}
