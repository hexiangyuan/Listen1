package io.github.listen1.main.featured

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.github.listen1.R
import io.github.listen1.main.modal.FeaturedItem
import kotlinx.android.synthetic.main.layout_refresh_recyclerview.*

class FeaturedFragment : Fragment(), FeaturedContract.View {
    private lateinit var adapter: FeaturedAdapter
    private lateinit var presenter: FeaturedContract.Presenter
    private var page = 1
    private var isLoadingMore = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.layout_refresh_recyclerview, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val gridLayoutManager = GridLayoutManager(context, 2)
        recyclerView.layoutManager = gridLayoutManager
        presenter = XiaMiFeaturedPresenter(this)
        adapter = FeaturedAdapter()
        swipeLayout.setOnRefreshListener {
            page = 1
            presenter.onFreshLoadFeatured()
        }
        recyclerView.adapter = adapter
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                val firstVisibleItem = gridLayoutManager.findFirstVisibleItemPosition()
                val screenItemCount = gridLayoutManager.childCount
                val totalCount = gridLayoutManager.itemCount
                if (!isLoadingMore && dy > 0 && firstVisibleItem + screenItemCount >= totalCount - 4) {
                    page++
                    isLoadingMore = true
                    presenter.loadMoreFeatured(page)
                }
            }
        })
        presenter.onStart()
    }

    companion object {

        fun newInstance(): FeaturedFragment {
            val fragment = FeaturedFragment()
            return fragment
        }
    }

    override fun loadMoreStart() {
    }

    override fun loadMoreCompleted() {
        isLoadingMore = false
    }

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun featuredOnFirstLoaded(list: ArrayList<FeaturedItem>) {
        adapter.setList(list)
    }

    override fun showEmptyPage() {
    }

    override fun featuredOnRefreshed(list: ArrayList<FeaturedItem>) {
        adapter.setList(list)
        swipeLayout.isRefreshing = false
    }

    override fun featuredOnLoadingMore(list: ArrayList<FeaturedItem>) {
        adapter.addList(list)
    }

    override fun showErrorMsg(e: String) {
    }
}
