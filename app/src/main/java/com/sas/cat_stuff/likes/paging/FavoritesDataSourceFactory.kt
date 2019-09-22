package com.sas.cat_stuff.likes.paging

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.sas.data.model.Favorite

class FavoritesDataSourceFactory : DataSource.Factory<Int, Favorite>() {

    val favoriteDataSourceLiveData = MutableLiveData<FavoritesDataSource>()

    override fun create(): DataSource<Int, Favorite> {
        val newsDataSource = FavoritesDataSource()
        favoriteDataSourceLiveData.postValue(newsDataSource)
        return newsDataSource
    }
}