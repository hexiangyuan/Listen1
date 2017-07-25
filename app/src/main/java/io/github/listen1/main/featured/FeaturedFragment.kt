package io.github.listen1.main.featured

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.github.listen1.R
import io.github.listen1.main.modal.FeaturedItem

class FeaturedFragment : Fragment(),FeaturedContract.View {

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun featuredOnFirstLoaded(list: List<FeaturedItem>) {
    }

    override fun showEmptyPage() {
    }

    override fun featuredOnRefreshed(list: List<FeaturedItem>) {
    }

    override fun featuredOnLoadingMore(list: List<FeaturedItem>) {
    }

    override fun showErrorMsg(e: String) {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_featured, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val presenter:FeaturedContract.Presenter = XiaMiFeatruredPresenter(this)
        presenter.onStart()
    }

    companion object {

        fun newInstance(): FeaturedFragment {
            val fragment = FeaturedFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
}
