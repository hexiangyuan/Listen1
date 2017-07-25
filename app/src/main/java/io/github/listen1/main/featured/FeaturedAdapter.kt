package io.github.listen1.main.featured

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.github.listen1.R
import io.github.listen1.main.common.ImageUtils
import io.github.listen1.main.common.screenSize
import io.github.listen1.main.modal.FeaturedItem
import kotlinx.android.synthetic.main.layout_featured_item.view.*

/**
 * Created by hexiangyuan on 2017/7/25.
 * feature:
 */
class FeaturedAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var list = ArrayList<FeaturedItem>()

    fun setList(list: ArrayList<FeaturedItem>) {
        this.list = list
        notifyDataSetChanged()
    }

    fun addList(list: List<FeaturedItem>) {
        val oldSize = this.list.size
        this.list.addAll(list)
        notifyItemRangeChanged(oldSize, list.size)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        (holder as FeaturedViewHolder).onBind(list[position])
    }

    override fun getItemCount(): Int = this.list.size


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return FeaturedViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_featured_item, parent, false))
    }
}

class FeaturedViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val image = view.image!!
    val title = view.text!!

    fun onBind(featuredItem: FeaturedItem) {
        ImageUtils.loadUrl(featuredItem.imageSrc, image)
        title.text = featuredItem.title
    }
}