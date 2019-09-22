package com.sas.cat_stuff.likes.paging

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.sas.cat_stuff.BR
import com.sas.cat_stuff.util.scanForActivity

class BaseViewHolder(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root), LifecycleOwner {
    private val lifecycleRegistry = LifecycleRegistry(this)

    init {
        lifecycleRegistry.currentState = Lifecycle.State.INITIALIZED
    }

    fun bind(vm: ViewModel) {
        binding.setVariable(BR.vm, vm)
        binding.lifecycleOwner = binding.root.context.scanForActivity()
        binding.executePendingBindings()
    }

    override fun getLifecycle(): Lifecycle {
        return lifecycleRegistry
    }
}