package com.undabot.newsnow.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ArticlesResultResource(
  val articles: List<ArticleResource>? = null,
)
