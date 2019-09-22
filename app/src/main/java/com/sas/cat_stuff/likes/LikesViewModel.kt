package com.sas.cat_stuff.likes

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.sas.cat_stuff.common.BaseAndroidVM
import com.sas.cat_stuff.likes.paging.FavoritesDataSourceFactory
import com.sas.data.model.Favorite

class LikesViewModel : BaseAndroidVM() {

    companion object {
        const val PAGE_SIZE = 5
    }

    var favoriteList: LiveData<PagedList<Favorite>>
    private val favoritesDataSourceFactory: FavoritesDataSourceFactory = FavoritesDataSourceFactory()

    init {
        val config = PagedList.Config.Builder()
            .setPageSize(PAGE_SIZE)
            .setInitialLoadSizeHint(PAGE_SIZE)
            .setEnablePlaceholders(false)
            .build()

        favoriteList = LivePagedListBuilder<Int, Favorite>(favoritesDataSourceFactory, config).build()
    }
}