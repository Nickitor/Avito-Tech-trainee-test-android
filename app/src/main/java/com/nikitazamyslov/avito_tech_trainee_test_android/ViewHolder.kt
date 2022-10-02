package com.nikitazamyslov.avito_tech_trainee_test_android

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val id: TextView = view.findViewById(R.id.id)
    private val delete: ImageView = view.findViewById(R.id.delete)

    fun bind(item: Item) {
        id.text = item.id.toString()
    }

    fun setListener(listener: ((Item) -> Unit)?, item: Item) {
        delete.setOnClickListener {
            listener?.invoke(item)
        }
    }
}