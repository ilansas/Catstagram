package com.sas.cat_stuff.likes.paging

import androidx.paging.PageKeyedDataSource
import com.sas.cat_stuff.network.Requester
import com.sas.data.model.Favorite
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavoritesDataSource : PageKeyedDataSource<Int, Favorite>() {

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Favorite>) {
        CoroutineScope(Dispatchers.IO).launch {
            val result = Requester.getFavorites(1, params.requestedLoadSize)
            callback.onResult(result, null, 2)
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Favorite>) {
        CoroutineScope(Dispatchers.IO).launch {
            val result = Requester.getFavorites(params.key, params.requestedLoadSize)
            callback.onResult(result, params.key + 1)
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Favorite>) = Unit
}