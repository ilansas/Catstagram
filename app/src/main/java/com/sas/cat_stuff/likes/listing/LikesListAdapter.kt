package com.sas.cat_stuff.likes.listing

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.sas.cat_stuff.common.listing.BasePagedListAdapter
import com.sas.cat_stuff.common.viewmodel.BaseUpdatableVM
import com.sas.cat_stuff.databinding.ItemFavoriteCatCardBinding
import com.sas.cat_stuff.likes.viewmodel.LikedCatVM
import com.sas.cat_stuff.util.layoutInflater
import com.sas.core.domain.Favorite

class LikesListAdapter : BasePagedListAdapter<Favorite, ItemFavoriteCatCardBinding>(LikedDiffCallback) {

    companion object {
        val LikedDiffCallback = object : DiffUtil.ItemCallback<Favorite>() {
            override fun areItemsTheSame(oldItem: Favorite, newItem: Favorite) = oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Favorite, newItem: Favorite) = oldItem == newItem
        }
    }

    override fun getBinding(parent: ViewGroup, viewType: Int): ItemFavoriteCatCardBinding =
        ItemFavoriteCatCardBinding.inflate(parent.context.layoutInflater(), parent, false)

    override fun getVm(): BaseUpdatableVM<Favorite> = LikedCatVM()
}