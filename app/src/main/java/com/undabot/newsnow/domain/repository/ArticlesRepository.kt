package com.undabot.newsnow.domain.repository

import com.undabot.newsnow.data.service.ApiService
import com.undabot.newsnow.domain.model.Article
import com.undabot.newsnow.domain.model.Source
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ArticlesRepository @Inject constructor(
  private val apiService: ApiService,
  private val articlesStore: ArticlesStore,
) {

  companion object {

    // TODO ADD API KEY
    const val API_KEY = ""
  }

  suspend fun getArticlesFrom(source: Source): List<Article> = try {
    if (articlesStore.hasArticles(source)) {
      articlesStore.getArticles(source)
    } else {
      val remoteArticles =
        apiService.getArticlesFrom(source.id, API_KEY).articles?.map { it.toDomain() }
          ?: emptyList()
      articlesStore.saveArticles(source, remoteArticles)
      remoteArticles
    }
  } catch (e: Exception) {
    emptyList()
  }

  suspend fun getAvailableSources(): List<Source> = withContext(Dispatchers.IO) {
    listOf(
      Source("techcrunch", "TechCrunch"),
      Source("mtv-news", "MTV News"),
      Source("google-news", "Google News"),
      Source("espn", "ESPN"),
      Source("cnn", "CNN"),
      Source("buzzfeed", "Buzzfeed"),
      Source("the-lad-bible", "The Lad Bible"),
      Source("time", "Time"),
      Source("wired", "Wired"),
      Source("the-verge", "The Verge"),
    )
  }

  suspend fun getArticle(id: String): Article = withContext(Dispatchers.IO) {
    articlesStore.getArticle(id)
  }
}
