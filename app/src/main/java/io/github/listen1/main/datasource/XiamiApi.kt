package io.github.listen1.main.datasource

import io.github.listen1.main.modal.FeaturedItem
import org.jsoup.Jsoup
import org.jsoup.nodes.Document

/**
 * Created by hexiangyuan on 2017/7/25.
 * feature:
 */
class XiamiApi : IFeaturedApi {
    override fun getFeaturedList(page: Int): ArrayList<FeaturedItem> {
        try {
            val document: Document = Jsoup.connect("http://www.xiami.com/collect/recommend/page/$page").get()
            val liList = document.select("div.collectBlock_list").select("ul").select("li")
            val xiamiFeaturedList = arrayListOf<FeaturedItem>()
            for (li in liList) {
                val item = FeaturedItem()
                item.id = li.select("a").first().attr("href")
                item.title = li.select("a").first().attr("title")
                item.imageSrc = li.select("img").first().attr("src")
                xiamiFeaturedList.add(item)
            }
            return xiamiFeaturedList
        } catch (e: Exception) {
            throw Exception("NetWork or parse error")
        }
    }
}