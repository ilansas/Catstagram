package com.sas.cat_stuff.common.bundlemanager

import com.sas.data.model.Image

class BundleManager : BaseBundleManager<BundleManager>() {

    companion object {
        const val ARG_IMAGE = "arg_image"
        const val ARG_URL = "arg_url"
    }

    fun attachImage(image: Image): BundleManager {
        bundle.putParcelable(ARG_IMAGE, image)
        return this
    }

    fun extractImage(): Image? = bundle.getParcelable(ARG_IMAGE)

    fun attachUrl(url: String): BundleManager {
        bundle.putString(ARG_URL, url)
        return this
    }

    fun extractUrl(): String? = bundle.getString(ARG_URL)
}