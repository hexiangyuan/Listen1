package io.github.listen1.main.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import java.util.jar.Attributes

/**
 * Created by hexiangyuan on 2017/7/25.
 * feature:
 */
class SquareImageView : ImageView {
    constructor(context: Context) : super(context)

    constructor(context: Context?, attributes: AttributeSet) : super(context, attributes)

    constructor(context: Context,attributes: AttributeSet,defStyleAttr:Int):super(context,attributes,defStyleAttr)

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec)
    }
}