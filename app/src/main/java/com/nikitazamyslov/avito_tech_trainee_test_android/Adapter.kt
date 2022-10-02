package com.nikitazamyslov.avito_tech_trainee_test_android

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter

class Adapter : ListAdapter<Item, ViewHolder>(ItemDiffCallback()) {

    var clickListener: ((Item) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            val item = getItem(position)
            bind(item)
            setListener(clickListener, item)
        }
    }
}