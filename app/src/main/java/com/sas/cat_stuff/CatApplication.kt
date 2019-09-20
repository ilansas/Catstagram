package com.sas.cat_stuff

import android.app.Application

class CatApplication : Application() {

    companion object {
        lateinit var APP: CatApplication
    }

    override fun onCreate() {
        super.onCreate()
        APP = this
    }
}