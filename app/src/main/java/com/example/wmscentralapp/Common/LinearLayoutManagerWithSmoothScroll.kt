package com.example.wmscentralapp.Common

import android.app.Application
import android.content.Context
import android.graphics.PointF
import android.graphics.drawable.GradientDrawable
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSmoothScroller
import androidx.recyclerview.widget.RecyclerView
import org.jetbrains.annotations.Nullable

class LinearLayoutManagerWithSmoothScroll:LinearLayoutManager {

    val context = Application()
    constructor(context: Context) : super(context,LinearLayoutManager.VERTICAL,false)
    constructor(context: Context,orientation: Int,reverseLayout:Boolean):super(context,orientation,false)

    override fun smoothScrollToPosition(
        recyclerView: RecyclerView, state: RecyclerView.State, position: Int
    ) {
        val smoothScroll: RecyclerView.SmoothScroller =
            TopSnappedSmoothScroller(recyclerView.context)
        smoothScroll.targetPosition = position
        startSmoothScroll(smoothScroll)
    }



    inner class TopSnappedSmoothScroller(context: Context) : LinearSmoothScroller(context) {
        override fun computeScrollVectorForPosition(targetPosition: Int): PointF? {
            return  this@LinearLayoutManagerWithSmoothScroll.computeScrollVectorForPosition(targetPosition)
        }

        override fun getVerticalSnapPreference(): Int {
            return SNAP_TO_START
        }
    }
}