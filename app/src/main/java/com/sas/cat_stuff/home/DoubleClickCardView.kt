package com.sas.cat_stuff.home

import android.content.Context
import android.util.AttributeSet
import android.view.GestureDetector
import android.view.MotionEvent
import androidx.cardview.widget.CardView

class DoubleClickCardView : CardView {

    private val gestureDetector = GestureDetector(context, GestureListener())
    private var onDoubleClickListener: OnDoubleClickListener? = null

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return gestureDetector.onTouchEvent(event)
    }

    private inner class GestureListener : GestureDetector.SimpleOnGestureListener() {

        override fun onDown(e: MotionEvent): Boolean {
            return true
        }

        // event when double tap occurs
        override fun onDoubleTap(e: MotionEvent): Boolean {
            onDoubleClickListener?.onDoubleClick(this@DoubleClickCardView)
            return true
        }
    }

    fun setOnDoubleClickListener(onDoubleClickListener: OnDoubleClickListener?) {
        this.onDoubleClickListener = onDoubleClickListener
    }

    interface OnDoubleClickListener {
        fun onDoubleClick(view: DoubleClickCardView)
    }
}