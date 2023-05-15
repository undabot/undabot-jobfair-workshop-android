package com.undabot.newshub.domain.model

data class Article(
  val id: String,
  val source: Source?,
  val author: String,
  val title: String,
  val description: String,
  val url: String,
  val urlToImage: String,
  val publishedAt: String,
  val content: String,
)
