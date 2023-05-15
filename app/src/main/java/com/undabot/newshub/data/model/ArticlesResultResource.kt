package com.undabot.newshub.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ArticlesResultResource(
  val articles: List<ArticleResource>? = null,
)
