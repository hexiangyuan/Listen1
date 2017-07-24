package io.github.listen1.main.featured

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import io.github.listen1.R

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [FeaturedFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [FeaturedFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FeaturedFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_featured, container, false)
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
