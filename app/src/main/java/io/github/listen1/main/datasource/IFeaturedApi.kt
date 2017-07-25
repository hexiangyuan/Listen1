package io.github.listen1.main.datasource

import io.github.listen1.main.modal.FeaturedItem

/**
 * Created by hexiangyuan on 2017/7/25.
 * feature:
 */
interface IFeaturedApi {
    fun getFeaturedList(page:Int = 1):ArrayList<FeaturedItem>
}