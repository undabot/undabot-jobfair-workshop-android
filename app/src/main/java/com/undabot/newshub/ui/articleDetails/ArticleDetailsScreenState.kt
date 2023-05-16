package com.undabot.newshub.ui.articleDetails

import com.undabot.newshub.domain.model.Article

data class ArticleDetailsScreenState(
  val isLoading: Boolean = true,
  val article: Article? = null,
)
