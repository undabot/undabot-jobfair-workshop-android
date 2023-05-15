package com.undabot.newsnow.domain.repository

import com.undabot.newsnow.data.service.ApiService
import com.undabot.newsnow.domain.model.Article
import com.undabot.newsnow.domain.model.Source
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ArticlesRepository @Inject constructor(
  private val apiService: ApiService,
) {

  companion object {

    // TODO ADD API KEY
    const val API_KEY = ""
  }

  suspend fun getArticlesFrom(source: String): List<Article> = try {
    apiService.getArticlesFrom(source, API_KEY).articles?.map { it.toDomain() } ?: emptyList()
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
}
