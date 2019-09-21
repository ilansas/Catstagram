package com.sas.cat_stuff.card

import com.sas.cat_stuff.common.BaseUpdatableVM
import com.sas.cat_stuff.home.DoubleClickCardView
import com.sas.data.model.Image

class CatCardVM : BaseUpdatableVM<Image>() {

    var onDoubleClickListener: OnDoubleClickListener? = null

    val imageUrl = data.map { it.url }

    val onDoubleClick = object : DoubleClickCardView.OnDoubleClickListener {
        override fun onDoubleClick(view: DoubleClickCardView) {
            onDoubleClickListener?.onDoubleClick(view)
        }
    }

    interface OnDoubleClickListener {
        fun onDoubleClick(view: DoubleClickCardView)
    }
}