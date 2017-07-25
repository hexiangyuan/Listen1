package io.github.listen1.main.featured


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.github.listen1.R
import kotlinx.android.synthetic.main.fragment_featured1.*

class Featured1Fragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_featured1, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val fragments = ArrayList<Fragment>()
        viewPager.adapter = FeaturedViewPagerAdapter(childFragmentManager,fragments)
        tabLayout.setupWithViewPager(viewPager)

    }

    companion object {
        fun newInstance(): Featured1Fragment {
            val fragment = Featured1Fragment()
            return fragment
        }
    }

    class FeaturedViewPagerAdapter(fm: FragmentManager,var fragments:ArrayList<Fragment>) : FragmentPagerAdapter(fm) {
        val titles = arrayOf("网易", "虾米", "QQ音乐")

        override fun getItem(position: Int): Fragment {
            return fragments[position]
        }

        override fun getCount(): Int {
            return 3;
        }

        override fun getPageTitle(position: Int): CharSequence {
            return titles[position]
        }

    }

}
