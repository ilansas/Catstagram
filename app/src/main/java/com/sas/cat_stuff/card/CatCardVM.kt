package com.sas.cat_stuff.card

import com.sas.cat_stuff.common.BaseUpdatableVM
import com.sas.data.model.Image

class CatCardVM : BaseUpdatableVM<Image>() {

    val imageUrl = data.map { it.url }
}