package io.github.listen1.main.featured

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.layout_refresh_recyclerview, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        adapter = FeaturedAdapter()
        recyclerView.adapter = adapter
        val presenter: FeaturedContract.Presenter = XiaMiFeaturedPresenter(this)
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
    }

    override fun featuredOnLoadingMore(list: ArrayList<FeaturedItem>) {
    }

    override fun showErrorMsg(e: String) {
    }
}
