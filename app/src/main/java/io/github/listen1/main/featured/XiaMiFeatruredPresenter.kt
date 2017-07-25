package io.github.listen1.main.featured

import io.github.listen1.main.datasource.IFeaturedApi
import io.github.listen1.main.datasource.XiamiApi
import io.github.listen1.main.modal.FeaturedItem
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by hexiangyuan on 2017/7/25.
 * feature:
 */
class XiaMiFeatruredPresenter(val v: FeaturedContract.View) : FeaturedContract.Presenter {
    private val api: IFeaturedApi

    init {
        api = XiamiApi()
    }

    override fun onStart() {
        v.showLoading()
        Observable.just(1)
                .map {
                    return@map api.getFeaturedList()
                }
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<List<FeaturedItem>> {
                    override fun onNext(list: List<FeaturedItem>) {
                        if(list.isEmpty()){
                            v.showEmptyPage()
                        }else{
                            v.featuredOnFirstLoaded(list)
                        }
                    }
                    override fun onError(p0: Throwable?) {
                        v.hideLoading()
                        v.showErrorMsg("网络异常")
                    }

                    override fun onComplete() {
                        v.hideLoading()
                    }

                    override fun onSubscribe(p0: Disposable?) {
                    }
                })
    }

    override fun onStop() {
    }

    override fun loadMoreFeatured(page: Int) {

    }

    override fun onFreshLoadFeatured() {

    }
}