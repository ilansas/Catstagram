package com.sas.cat_stuff.common.bundlemanager

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment

abstract class BaseBundleManager<T> {

    /**
     * Getter for the builder's bundle
     *
     * @return builder's bundle
     */
    var bundle: Bundle
        internal set

    init {
        bundle = Bundle()
    }

    private fun getBundle(activity: Activity?): Bundle? =
        if (activity != null) getBundle(activity.intent)
        else null

    private fun getBundle(intent: Intent?): Bundle? {
        return intent?.extras
    }

    private fun getBundle(fragment: Fragment?): Bundle? {
        return fragment?.arguments
    }

    private fun getBundle(fragment: android.app.Fragment?): Bundle? {
        return fragment?.arguments
    }


    /**
     * Extract bundle from activity and merge with builder's bundle
     *
     * @param activity from witch the bundle will be extracted
     * @return current builder
     */
    fun from(activity: Activity): T {
        return from(getBundle(activity))
    }

    /**
     * Extract bundle from intent and merge with builder's bundle
     *
     * @param intent from witch the bundle will be extracted
     * @return current builder
     */
    fun from(intent: Intent): T {
        return from(getBundle(intent))
    }

    /**
     * Extract bundle from fragment and merge with builder's bundle
     *
     * @param fragment from witch the bundle will be extracted
     * @return current builder
     */
    fun from(fragment: Fragment): T {
        return from(getBundle(fragment))
    }

    /**
     * Merge bundle with builder's one
     *
     * @param bundle to merge
     * @return current builder
     */
    fun from(bundle: Bundle?): T {
        if (bundle != null)
            this.bundle.putAll(bundle)
        return this as T
    }

    /**
     * Assign current builder's bundle into provided bundle
     *
     * @param bundle to be fulfilled
     */
    fun into(bundle: Bundle) {
        bundle.putAll(this.bundle)
    }

    /**
     * Assign current builder's bundle into provided activity's extras
     *
     * @param activity to be fulfilled
     */
    fun into(activity: Activity) {
        activity.intent.putExtras(bundle)
    }

    /**
     * Assign current builder's bundle into provided intent's extras
     *
     * @param intent to be fulfilled
     */
    fun into(intent: Intent) {
        intent.putExtras(bundle)
    }

    /**
     * Assign current builder's bundle into provided fragment's arguments
     *
     * @param fragment to be fulfilled
     */
    fun into(fragment: Fragment) {
        fragment.arguments = bundle
    }
}