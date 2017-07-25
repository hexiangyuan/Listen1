package io.github.listen1.main.common

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * Created by hexiangyuan on 2017/7/25.
 * feature:
 */
class ImageUtils {
    companion object {
        fun loadUrl(url: String, view: ImageView) {
            if (view.context != null) {
                Glide.with(view).load(url).into(view)
            }
        }
    }
}