package com.example.day2_miniprofile

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProfileInfoViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
    val title: TextView = itemView.findViewById(R.id.textHolderTV)
    val arrow: ImageView = itemView.findViewById(R.id.arrowHolderIV)
}