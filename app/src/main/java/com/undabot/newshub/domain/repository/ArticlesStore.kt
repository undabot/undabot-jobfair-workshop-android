package com.undabot.newshub.domain.repository

import com.undabot.newshub.domain.model.Article
import com.undabot.newshub.domain.model.Source
import javax.inject.Inject

class ArticlesStore @Inject constructor() {

  private val cache = HashMap<String, List<Article>>()

  fun hasArticles(source: Source): Boolean {
    return cache.containsKey(source.id)
  }

  fun getArticles(source: Source): List<Article> {
    return cache[source.id] ?: emptyList()
  }

  fun saveArticles(source: Source, articles: List<Article>) {
    cache[source.id] = articles
  }

  fun getArticle(id: String): Article {
    return cache.values.flatten().first { it.id == id }
  }
}
