package com.undabot.newsnow.data.model

import com.squareup.moshi.JsonClass
import com.undabot.newsnow.domain.model.Article
import java.util.UUID

@JsonClass(generateAdapter = true)
data class ArticleResource(
  val source: SourceResource? = null,
  val author: String? = null,
  val title: String? = null,
  val description: String? = null,
  val url: String? = null,
  val urlToImage: String? = null,
  val publishedAt: String? = null,
  val content: String? = null,
) {

  fun toDomain(): Article {
    return Article(
      id = UUID.randomUUID().toString(),
      source = source?.toDomain(),
      author = author.orEmpty(),
      title = title.orEmpty(),
      description = description.orEmpty(),
      url = url.orEmpty(),
      urlToImage = urlToImage.orEmpty(),
      publishedAt = publishedAt.orEmpty(),
      content = content.orEmpty(),
    )
  }
}
