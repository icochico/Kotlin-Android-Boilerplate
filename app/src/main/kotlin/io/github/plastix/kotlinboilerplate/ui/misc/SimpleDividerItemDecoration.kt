package io.github.plastix.kotlinboilerplate.ui.misc

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import io.github.plastix.kotlinboilerplate.ApplicationQualifier
import io.github.plastix.kotlinboilerplate.R
import javax.inject.Inject

/**
 * Simple divider decorator for a RecyclerView.
 *
 * Adapted from https://gist.github.com/polbins/e37206fbc444207c0e92
 */
class SimpleDividerItemDecoration @Inject constructor(
        @ApplicationQualifier context: Context
) : RecyclerView.ItemDecoration() {

    private val divider: Drawable = ContextCompat.getDrawable(context, R.drawable.line_divider)!!

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        val left = parent.paddingLeft
        val right = parent.width - parent.paddingRight

        val childCount = parent.childCount
        for (i in 0 until childCount) {
            val child = parent.getChildAt(i)

            val params = child.layoutParams as RecyclerView.LayoutParams

            val top = child.bottom + params.bottomMargin
            val bottom = top + divider.intrinsicHeight

            divider.setBounds(left, top, right, bottom)
            divider.draw(c)
        }
    }
}