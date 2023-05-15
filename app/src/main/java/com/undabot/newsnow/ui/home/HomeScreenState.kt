package com.undabot.newsnow.ui.home

import com.undabot.newsnow.domain.model.Article

data class HomeScreenState(
  val isLoading: Boolean = true,
  val articles: List<Article> = emptyList(),
)
