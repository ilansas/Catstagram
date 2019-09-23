package com.sas.cat_stuff.home.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.sas.cat_stuff.common.viewmodel.ViewModelFactory
import com.sas.cat_stuff.databinding.ActivityMainBinding
import com.sas.cat_stuff.databinding.CatCardBinding
import com.sas.cat_stuff.home.bottomsheet.InfosBottomSheetDialogFragment
import com.sas.cat_stuff.home.card.view.DoubleClickCardView
import com.sas.cat_stuff.home.card.viewmodel.CatCardVM
import com.sas.cat_stuff.home.viewmodel.HomeViewModel
import com.sas.cat_stuff.likes.activity.LikesActivity
import com.sas.cat_stuff.util.pop
import com.sas.data.model.Image


class HomeActivity : AppCompatActivity(), CatCardVM.OnDoubleClickListener, CatCardVM.OnInfoClickListener {

    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, com.sas.cat_stuff.R.layout.activity_main).apply {
            lifecycleOwner = this@HomeActivity
        }

        viewModel = ViewModelProviders.of(this, ViewModelFactory)[HomeViewModel::class.java]

        binding.vm = viewModel

        viewModel.images.observe(this, Observer { images ->
            if (images != null && images.size == 3) {
                binding.firstCat.vm = CatCardVM().apply {
                    onDoubleClickListener = this@HomeActivity
                    onInfoClickListener = this@HomeActivity
                    setData(images[0])
                }
                binding.secondCat.vm = CatCardVM().apply {
                    onDoubleClickListener = this@HomeActivity
                    onInfoClickListener = this@HomeActivity
                    setData(images[1])
                }
                binding.thirdCat.vm = CatCardVM().apply {
                    onDoubleClickListener = this@HomeActivity
                    onInfoClickListener = this@HomeActivity
                    setData(images[2])
                }
            }
        })

        viewModel.downloadRandomCatImages()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(com.sas.cat_stuff.R.menu.option_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == com.sas.cat_stuff.R.id.likes) {
            LikesActivity.openActivity(this)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDoubleClick(view: DoubleClickCardView) =
        DataBindingUtil.getBinding<CatCardBinding>(view)?.heart?.pop() ?: Unit

    override fun onInfoClick(image: Image?) {
        image ?: return
        InfosBottomSheetDialogFragment.getInstance(image).let {
            it.show(supportFragmentManager, it.tag)
        }
    }
}
