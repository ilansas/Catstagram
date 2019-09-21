package com.sas.cat_stuff.util

import android.animation.Animator
import android.animation.ValueAnimator
import android.view.View
import android.view.animation.LinearInterpolator
import android.view.animation.OvershootInterpolator


fun View.pop(duration: Long = 300, startDelay: Long = 0) {
    alpha = 0f
    scaleX = 0f
    scaleY = 0f
    visibility = View.VISIBLE

    ValueAnimator.ofFloat(0f, 1f).apply {
        this.startDelay = startDelay
        this.duration = duration
        interpolator = OvershootInterpolator()
        addUpdateListener { animator ->
            alpha = animator.animatedFraction
            scaleX = animator.animatedFraction
            scaleY = animator.animatedFraction
        }
        addListener(object: Animator.AnimatorListener {
            override fun onAnimationRepeat(animation: Animator?) = Unit
            override fun onAnimationEnd(animation: Animator?) = fadeOut(startDelay = 200)
            override fun onAnimationCancel(animation: Animator?) = Unit
            override fun onAnimationStart(animation: Animator?) = Unit
        })
    }.start()
}

fun View.fadeOut(duration: Long = 200, startDelay: Long = 0) {
    alpha = 1f
    visibility = View.VISIBLE

    ValueAnimator.ofFloat(1f, 0f).apply {
        this.startDelay = startDelay
        this.duration = duration
        interpolator = LinearInterpolator()

        addUpdateListener { animator -> alpha = animator.animatedValue as Float }
        addListener(object: Animator.AnimatorListener {
            override fun onAnimationRepeat(animation: Animator?) = Unit
            override fun onAnimationEnd(animation: Animator?) { visibility = View.GONE }
            override fun onAnimationCancel(animation: Animator?) = Unit
            override fun onAnimationStart(animation: Animator?) = Unit
        })
    }.start()
}
