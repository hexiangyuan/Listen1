package io.github.listen1.main

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import io.github.listen1.R
import io.github.listen1.main.featured.AboutFragment
import io.github.listen1.main.featured.CollectionFragment
import io.github.listen1.main.featured.FeaturedFragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        when (item.itemId) {
            R.id.navigation_featured -> {
                if (currentFragment === featuredFragment) {
                    return@OnNavigationItemSelectedListener true
                } else {
                    fragmentTransaction.hide(currentFragment)
                            .show(featuredFragment)
                            .commit()
                    currentFragment = featuredFragment
                    return@OnNavigationItemSelectedListener true
                }
            }
            R.id.navigation_collection -> {
                if (currentFragment === collectionFragment) {
                    return@OnNavigationItemSelectedListener true
                } else {
                    if (collectionFragment == null) {
                        collectionFragment = CollectionFragment.newInstance()
                        fragmentTransaction
                                .hide(currentFragment)
                                .add(R.id.content, collectionFragment, "collection")
                                .commit()
                    } else {
                        fragmentTransaction
                                .hide(currentFragment)
                                .show(collectionFragment)
                                .commit()
                    }
                    currentFragment = collectionFragment
                    return@OnNavigationItemSelectedListener true
                }
            }
            R.id.navigation_about -> {
                if (currentFragment === aboutFragment) {
                    return@OnNavigationItemSelectedListener true
                } else {
                    if (aboutFragment == null) {
                        aboutFragment = AboutFragment.newInstance()
                        fragmentTransaction
                                .hide(currentFragment)
                                .add(R.id.content, aboutFragment, "about")
                                .commit()
                    } else {
                        fragmentTransaction
                                .hide(currentFragment)
                                .show(aboutFragment).commit()
                    }
                    currentFragment = aboutFragment
                    return@OnNavigationItemSelectedListener true
                }
            }
        }
        false
    }

    private var featuredFragment: FeaturedFragment? = null
    private var aboutFragment: AboutFragment? = null
    private var collectionFragment: CollectionFragment? = null
    private var currentFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        featuredFragment = supportFragmentManager.findFragmentByTag("featured") as FeaturedFragment?
        aboutFragment = supportFragmentManager.findFragmentByTag("collection") as AboutFragment?
        collectionFragment = supportFragmentManager.findFragmentByTag("about") as CollectionFragment?
        if (featuredFragment == null) {
            featuredFragment = FeaturedFragment.newInstance()
            supportFragmentManager.beginTransaction().add(R.id.content, featuredFragment, "featured").commit()
            currentFragment = featuredFragment
        }
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
