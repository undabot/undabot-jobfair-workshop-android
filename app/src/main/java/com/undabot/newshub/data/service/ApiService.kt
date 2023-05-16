package com.undabot.newshub.data.service

import com.undabot.newshub.data.model.ArticlesResultResource
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

  @GET("top-headlines")
  suspend fun getArticlesFrom(
    @Query("sources") source: String,
    @Query("apiKey") apiKey: String,
  ): ArticlesResultResource
}
