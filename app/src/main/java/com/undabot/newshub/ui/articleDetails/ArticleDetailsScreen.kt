package com.undabot.newshub.ui.articleDetails

import androidx.compose.animation.Crossfade
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.undabot.newshub.ui.components.LoadingContent

@Composable
fun ArticleDetailsScreen(
  viewModel: ArticleDetailsScreenViewModel = hiltViewModel(),
) {

  val state: ArticleDetailsScreenState by viewModel.state.collectAsState()

  Crossfade(
    targetState = state.isLoading,
  ) { isLoading ->
    if (isLoading) {
      LoadingContent()
    } else {
      state.article?.let { ArticleDetailsScreenContent(it) }
    }
  }
}
