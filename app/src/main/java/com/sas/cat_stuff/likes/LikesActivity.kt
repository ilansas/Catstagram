package com.sas.cat_stuff.likes

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.sas.cat_stuff.R
import com.sas.cat_stuff.common.ViewModelFactory
import com.sas.cat_stuff.databinding.ActivityLikesBinding
import com.sas.cat_stuff.likes.paging.LikesListAdapter

class LikesActivity : AppCompatActivity() {

    lateinit var viewModel: LikesViewModel
    lateinit var binding: ActivityLikesBinding
    lateinit var listAdapter: LikesListAdapter

    companion object {
        fun openActivity(context: Context) = context.startActivity(Intent(context, LikesActivity::class.java))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityLikesBinding>(this, R.layout.activity_likes).apply {
            lifecycleOwner = this@LikesActivity
        }

        viewModel = ViewModelProviders.of(this, ViewModelFactory)[LikesViewModel::class.java]

        binding.vm = viewModel

        listAdapter = LikesListAdapter()
        binding.recycler.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = listAdapter
        }

        viewModel.favoriteList.observe(this, Observer {
            listAdapter.submitList(it)
        })
    }
}