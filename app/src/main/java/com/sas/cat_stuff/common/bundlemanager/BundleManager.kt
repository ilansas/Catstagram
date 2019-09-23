package com.sas.cat_stuff.common.bundlemanager

import com.sas.data.model.Image

class BundleManager : BaseBundleManager<BundleManager>() {

    companion object {
        const val ARG_IMAGE = "arg_image"
    }

    fun attachImage(image: Image): BundleManager {
        bundle.putParcelable(ARG_IMAGE, image)
        return this
    }

    fun extractImage(): Image? = bundle.getParcelable(ARG_IMAGE)
}