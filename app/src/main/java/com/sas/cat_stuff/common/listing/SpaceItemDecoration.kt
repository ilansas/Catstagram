package com.sas.cat_stuff.common.listing

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class SpaceItemDecoration
/**
 * @param space             the amount of space between item
 * @param addSpaceFirstItem should the first item have space before him
 * @param addSpaceLastItem  should the last item have space after him
 */ @JvmOverloads constructor(
    private var space: Int,
    addSpaceFirstItem: Boolean = false,
    addSpaceLastItem: Boolean = false
) : RecyclerView.ItemDecoration() {
    private var spaceBeforeFirstItem: Int = 0
    private var spaceAfterLastItem: Int = 0

    init {
        this.spaceBeforeFirstItem = if (addSpaceFirstItem) space else 0
        this.spaceAfterLastItem = if (addSpaceLastItem) space else 0
    }

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        if (space <= 0) {
            return
        }

        //First item
        if (spaceBeforeFirstItem != 0 && parent.getChildLayoutPosition(view) < 1) {
            getItemOffsetOfFirstItem(outRect, view, parent, state)
            return
        }

        //Not first item
        if (parent.getChildLayoutPosition(view) >= 1) {
            getItemOffsetOfClassicItems(outRect, view, parent, state)
        }

        //Last item
        if (spaceAfterLastItem != 0 && parent.getChildAdapterPosition(view) == getTotalItemCount(parent) - 1) {
            getItemOffsetOfLastItem(outRect, view, parent, state)
        }
    }

    protected fun getItemOffsetOfFirstItem(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        if (getOrientation(parent) == LinearLayoutManager.VERTICAL) {
            outRect.top = spaceBeforeFirstItem
        } else {
            outRect.left = spaceBeforeFirstItem
        }
    }

    protected fun getItemOffsetOfClassicItems(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        if (getOrientation(parent) == LinearLayoutManager.VERTICAL) {
            outRect.top = space
        } else {
            outRect.left = space
        }
    }

    protected fun getItemOffsetOfLastItem(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        if (getOrientation(parent) == LinearLayoutManager.VERTICAL) {
            outRect.bottom = spaceAfterLastItem
        } else {
            outRect.right = spaceAfterLastItem
        }
    }

    private fun getTotalItemCount(parent: RecyclerView): Int {
        return parent.adapter!!.itemCount
    }

    protected fun getOrientation(parent: RecyclerView): Int {
        return if (parent.layoutManager is LinearLayoutManager) {
            (parent.layoutManager as LinearLayoutManager).orientation
        } else {
            throw IllegalStateException("SpaceItemDecoration can only be used with a LinearLayoutManager.")
        }
    }
}
