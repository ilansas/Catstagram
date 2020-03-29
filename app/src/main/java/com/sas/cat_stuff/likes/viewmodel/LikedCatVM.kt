package com.sas.cat_stuff.likes.viewmodel

import com.sas.cat_stuff.common.viewmodel.BaseUpdatableVM
import com.sas.core.domain.Favorite

class LikedCatVM : BaseUpdatableVM<Favorite>() {

    val imageUrl = data.map { it.image?.url }

}