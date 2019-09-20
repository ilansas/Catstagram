package com.sas.cat_stuff.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.sas.cat_stuff.R
import com.sas.cat_stuff.card.CatCardVM
import com.sas.cat_stuff.common.ViewModelFactory
import com.sas.cat_stuff.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main).apply {
            lifecycleOwner = this@MainActivity
        }

        viewModel = ViewModelProviders.of(this, ViewModelFactory)[MainViewModel::class.java]

        binding.vm = viewModel
    }

    override fun onStart() {
        super.onStart()
        viewModel.images.observe(this, Observer { images ->
            if (images != null && images.size == 3) {
                binding.firstCat.vm = CatCardVM().apply { setData(images[0]) }
                binding.secondCat.vm = CatCardVM().apply { setData(images[1]) }
                binding.thirdCat.vm = CatCardVM().apply { setData(images[2]) }
            }
        })
        viewModel.downloadRandomCatImages()
    }
}
