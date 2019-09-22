package com.sas.cat_stuff.home.card.viewmodel

import android.widget.Toast
import com.sas.cat_stuff.R
import com.sas.cat_stuff.common.viewmodel.BaseUpdatableVM
import com.sas.cat_stuff.home.card.view.DoubleClickCardView
import com.sas.cat_stuff.network.Requester
import com.sas.data.model.Image
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class CatCardVM : BaseUpdatableVM<Image>() {

    var onDoubleClickListener: OnDoubleClickListener? = null

    val imageUrl = data.map { it.url }

    val onDoubleClick = object : DoubleClickCardView.OnDoubleClickListener {
        override fun onDoubleClick(view: DoubleClickCardView) {
            onDoubleClickListener?.onDoubleClick(view)

            data.value?.id?.let { id ->
                CoroutineScope(Dispatchers.Main).launch {
                    val task = async(Dispatchers.IO) {
                        Requester.addImageToFavorite(id)
                    }
                    val result = task.await()
                    if (result.isSuccess()) {
                        Toast.makeText(getContext(), R.string.picture_added_to_favorites, Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(getContext(), R.string.error_happened, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    interface OnDoubleClickListener {
        fun onDoubleClick(view: DoubleClickCardView)
    }
}