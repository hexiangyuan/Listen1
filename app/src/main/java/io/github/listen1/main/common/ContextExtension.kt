package io.github.listen1.main.common

import android.content.Context

/**
 * Created by hexiangyuan on 2017/7/25.
 * feature:
 */
fun Context.screenSize(): Pair<Int, Int> {
    return Pair(applicationContext.resources.displayMetrics.widthPixels, applicationContext.resources.displayMetrics.heightPixels)
}