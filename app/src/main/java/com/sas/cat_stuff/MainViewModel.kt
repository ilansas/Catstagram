package com.sas.cat_stuff

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.sas.cat_stuff.network.Requester
import com.sas.data.model.Breed
import kotlinx.coroutines.launch

class MainViewModel : BaseAndroidVM() {

    var breeds = listOf<Breed>()

    fun downloadBreeds() {
        viewModelScope.launch {
            breeds = Requester.fetch()
            Log.d("Breeds done", "fjeof")
        }
    }
}