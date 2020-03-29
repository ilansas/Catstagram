package com.sas.cat_stuff.likes.paging

import androidx.paging.DataSource
import com.sas.core.domain.Favorite

class FavoritesDataSourceFactory : DataSource.Factory<Int, Favorite>() {

    override fun create(): DataSource<Int, Favorite> = FavoritesDataSource()
}