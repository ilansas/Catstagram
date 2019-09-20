package com.sas.cat_stuff

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.sas.cat_stuff.common.ViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this, ViewModelFactory)[MainViewModel::class.java]
    }

    override fun onStart() {
        super.onStart()
        viewModel.downloadBreeds()
    }
}
