package com.sas.cat_stuff.home.card.viewmodel

import android.widget.Toast
import com.sas.cat_stuff.R
import com.sas.cat_stuff.common.viewmodel.BaseUpdatableVM
import com.sas.cat_stuff.framework.NetworkLikeDataSource
import com.sas.cat_stuff.home.card.view.DoubleClickCardView
import com.sas.core.data.LikeRepository
import com.sas.core.domain.Image
import com.sas.core.interactors.AddLikeInteractor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CatCardVM : BaseUpdatableVM<Image>() {

    var onDoubleClickListener: OnDoubleClickListener? = null
    var onInfoClickListener: OnInfoClickListener? = null

    val imageUrl = data.map { it.url }

    val infoButtonVisibility = data.map { !it.breeds.isNullOrEmpty() }

    fun onInfoClick() {
        onInfoClickListener?.onInfoClick(data.value)
    }

    val onDoubleClick = object : DoubleClickCardView.OnDoubleClickListener {
        override fun onDoubleClick(view: DoubleClickCardView) {
            onDoubleClickListener?.onDoubleClick(view)

            data.value?.let { image ->
                CoroutineScope(Dispatchers.Main).launch {
                    val result = withContext(Dispatchers.IO) {
                        AddLikeInteractor(LikeRepository(NetworkLikeDataSource()))(image)
                    }

                    Toast.makeText(
                        getContext(),
                        if (result.isSuccess()) R.string.picture_added_to_favorites else R.string.error_happened,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    interface OnDoubleClickListener {
        fun onDoubleClick(view: DoubleClickCardView)
    }

    interface OnInfoClickListener {
        fun onInfoClick(image: Image?)
    }
}