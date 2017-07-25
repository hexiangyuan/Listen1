package io.github.listen1.main.featured

import io.github.listen1.main.modal.FeaturedItem

/**
 * Created by hexiangyuan on 2017/7/25.
 * feature:
 */
interface FeaturedContract {
    interface View {

        fun showLoading()

        fun hideLoading()

        fun featuredOnFirstLoaded(list: List<FeaturedItem>)

        fun showEmptyPage()

        fun featuredOnRefreshed(list: List<FeaturedItem>)

        fun featuredOnLoadingMore(list: List<FeaturedItem>)

        fun showErrorMsg(e:String)
    }

    interface Presenter {
        fun onStart()

        fun onStop()

        fun loadMoreFeatured(page:Int)

        fun onFreshLoadFeatured()

    }
}