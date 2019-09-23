package com.sas.cat_stuff.likes.paging

import androidx.paging.DataSource
import com.sas.data.model.Favorite

class FavoritesDataSourceFactory : DataSource.Factory<Int, Favorite>() {

    override fun create(): DataSource<Int, Favorite> = FavoritesDataSource()
}