package com.undabot.newsnow.ui.home

import com.undabot.newsnow.domain.model.Article
import com.undabot.newsnow.domain.model.Source

data class HomeScreenState(
  val isLoading: Boolean = true,
  val articles: List<Article> = emptyList(),
  val availableSources: List<Source> = emptyList(),
  val currentSource: Source? = null,
)
