package com.sas.cat_stuff.home.bottomsheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.sas.cat_stuff.common.bundlemanager.BundleManager
import com.sas.cat_stuff.databinding.BottomSheetInfosBinding
import com.sas.core.domain.Image

class InfosBottomSheetDialogFragment : BottomSheetDialogFragment() {

    companion object {
        fun getInstance(image: Image) = InfosBottomSheetDialogFragment().also {
            BundleManager().attachImage(image).into(it)
        }
    }

    private var image: Image? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        image = BundleManager().from(this).extractImage()
        image ?: dismiss()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = BottomSheetInfosBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this@InfosBottomSheetDialogFragment
        binding.vm = InfosBottomSheetVM().apply {
            setData(image)
        }
        return binding.root
    }
}