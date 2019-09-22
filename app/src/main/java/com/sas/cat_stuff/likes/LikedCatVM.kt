package com.sas.cat_stuff.likes

import com.sas.cat_stuff.common.BaseUpdatableVM
import com.sas.data.model.Favorite

class LikedCatVM : BaseUpdatableVM<Favorite>() {

    val imageUrl = data.map { it.image?.url }


}