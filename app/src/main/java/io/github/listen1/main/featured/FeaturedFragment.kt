package io.github.listen1.main.featured

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.github.listen1.R
import org.jsoup.Jsoup
import org.jsoup.nodes.Document

class FeaturedFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_featured, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Thread({
            try {
                val document:Document = Jsoup.connect("http://www.xiami.com/collect/recommend/page/1").get()
                val elements = document.select("block_list clearfix")
            }catch (e:Exception){

            }
        }).start()
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
