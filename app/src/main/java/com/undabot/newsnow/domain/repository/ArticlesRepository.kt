package com.undabot.newsnow.domain.repository

import com.undabot.newsnow.data.service.ApiService
import com.undabot.newsnow.domain.model.Article
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
}
