package com.undabot.newshub.ui.home

import com.undabot.newshub.domain.model.Article
import com.undabot.newshub.domain.model.Source

data class HomeScreenState(
  val isLoading: Boolean = true,
  val articles: List<Article> = emptyList(),
  val availableSources: List<Source> = emptyList(),
  val currentSource: Source? = null,
)
