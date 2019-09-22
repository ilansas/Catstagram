package com.sas.cat_stuff.likes.paging

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.sas.cat_stuff.common.BaseUpdatableVM

abstract class BasePagedListAdapter<T, V : ViewDataBinding>(diffCallback: DiffUtil.ItemCallback<T>) :
    PagedListAdapter<T, BaseViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = BaseViewHolder(getBinding(parent, viewType))

    abstract fun getBinding(parent: ViewGroup, viewType: Int): V

    abstract fun getVm(): BaseUpdatableVM<T>

    override fun onBindViewHolder(viewHolder: BaseViewHolder, position: Int) {
        val vm = getVm()
        viewHolder.bind(vm)
        vm.setData(getItem(position))
    }
}