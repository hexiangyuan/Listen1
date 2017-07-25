package io.github.listen1.main.featured

import io.github.listen1.main.datasource.IFeaturedApi
import io.github.listen1.main.datasource.XiamiApi
import io.github.listen1.main.modal.FeaturedItem
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by hexiangyuan on 2017/7/25.
 * feature:
 */
class XiaMiFeaturedPresenter(val v: FeaturedContract.View) : FeaturedContract.Presenter {
    private val api: IFeaturedApi
    private val disposable = CompositeDisposable()


    init {
        api = XiamiApi()
    }

    override fun onStart() {
        v.showLoading()
        val subscribe = Observable.just(1)
                .map {
                    return@map api.getFeaturedList()
                }
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ list ->
                    if (list.isEmpty()) {
                        v.showEmptyPage()
                    } else {
                        v.featuredOnFirstLoaded(list)
                    }
                    v.hideLoading()
                }, {
                    v.hideLoading()
                    v.showErrorMsg("网络异常")
                })

        disposable.add(subscribe)
    }

    override fun onStop() {
        if (!disposable.isDisposed) {
            disposable.dispose()
        }
    }

    override fun loadMoreFeatured(page: Int) {
        v.loadMoreStart()
        val subscribe = Observable.create<ArrayList<FeaturedItem>> {
            observableEmitter ->
            observableEmitter.onNext(api.getFeaturedList(page))
        }.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io()).subscribe({ list ->
            if (list.isEmpty()) {
                v.showEmptyPage()
            } else {
                v.featuredOnLoadingMore(list)
            }
            v.loadMoreCompleted()
        }, {
            v.loadMoreCompleted()
            v.showErrorMsg("网络异常")
        })
        disposable.add(subscribe)
    }

    override fun onFreshLoadFeatured() {
        val subscribe = Observable.just(1)
                .map {
                    return@map api.getFeaturedList()
                }
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ list ->
                    if (list.isEmpty()) {
                        v.showEmptyPage()
                    } else {
                        v.featuredOnRefreshed(list)
                    }
                }, {
                    v.showErrorMsg("网络异常")
                })

        disposable.add(subscribe)
    }
}