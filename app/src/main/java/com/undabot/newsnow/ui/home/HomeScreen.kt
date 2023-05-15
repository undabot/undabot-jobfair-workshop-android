package com.undabot.newsnow.ui.home

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.undabot.newsnow.ui.components.LoadingContent

@Composable
fun HomeScreen(
  navigateToArticleDetails: (String) -> Unit,
  viewModel: HomeViewModel = hiltViewModel(),
) {
  val state: HomeScreenState by viewModel.state.collectAsState()

  Crossfade(
    targetState = state.isLoading,
    animationSpec = tween(500),
  ) { isLoading ->
    if (isLoading) {
      LoadingContent()
    } else {
      HomeScreenContent(
        state = state,
        onSourceClick = { viewModel.changeSource(it) },
        onArticleClick = { navigateToArticleDetails(it.id) },
      )
    }
  }
}
