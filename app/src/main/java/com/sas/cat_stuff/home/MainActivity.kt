package com.sas.cat_stuff.home

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.sas.cat_stuff.R
import com.sas.cat_stuff.common.ViewModelFactory
import com.sas.cat_stuff.databinding.ActivityMainBinding
import com.sas.cat_stuff.databinding.CatCardBinding
import com.sas.cat_stuff.home.card.CatCardVM
import com.sas.cat_stuff.home.card.DoubleClickCardView
import com.sas.cat_stuff.likes.LikesActivity
import com.sas.cat_stuff.util.pop



class MainActivity : AppCompatActivity(), CatCardVM.OnDoubleClickListener {

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
                binding.firstCat.vm = CatCardVM().apply {
                    onDoubleClickListener = this@MainActivity
                    setData(images[0])
                }
                binding.secondCat.vm = CatCardVM().apply {
                    onDoubleClickListener = this@MainActivity
                    setData(images[1])
                }
                binding.thirdCat.vm = CatCardVM().apply {
                    onDoubleClickListener = this@MainActivity
                    setData(images[2])
                }
            }
        })
        viewModel.downloadRandomCatImages()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.option_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.likes) {
            LikesActivity.openActivity(this)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDoubleClick(view: DoubleClickCardView) {
        val bind = DataBindingUtil.getBinding<CatCardBinding>(view)
        bind?.heart?.pop()
    }
}
