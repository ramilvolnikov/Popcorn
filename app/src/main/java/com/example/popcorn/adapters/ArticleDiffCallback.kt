package com.example.popcorn.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.popcorn.viewmodels.ItemsModel

class ArticleDiffCallback : DiffUtil.ItemCallback<ItemsModel>() {
    override fun areItemsTheSame(oldItem: ItemsModel, newItem: ItemsModel): Boolean {
        return oldItem.fullTitle == newItem.fullTitle && oldItem.imDbRating == newItem.imDbRating
    }

    override fun areContentsTheSame(oldItem: ItemsModel, newItem: ItemsModel): Boolean {
        return oldItem.fullTitle == newItem.fullTitle
    }
}