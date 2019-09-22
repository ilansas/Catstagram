package com.sas.cat_stuff.likes.paging

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.sas.cat_stuff.common.BaseUpdatableVM
import com.sas.cat_stuff.databinding.ItemFavoriteCatCardBinding
import com.sas.cat_stuff.likes.LikedCatVM
import com.sas.cat_stuff.util.layoutInflater
import com.sas.data.model.Favorite

class LikesListAdapter : BasePagedListAdapter<Favorite, ItemFavoriteCatCardBinding>(LikedDiffCallback) {

    companion object {
        val LikedDiffCallback = object : DiffUtil.ItemCallback<Favorite>() {
            override fun areItemsTheSame(oldItem: Favorite, newItem: Favorite): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Favorite, newItem: Favorite): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun getBinding(parent: ViewGroup, viewType: Int): ItemFavoriteCatCardBinding =
        ItemFavoriteCatCardBinding.inflate(parent.context.layoutInflater(), parent, false)

    override fun getVm(): BaseUpdatableVM<Favorite> = LikedCatVM()
}