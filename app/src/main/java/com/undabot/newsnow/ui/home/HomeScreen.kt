package com.undabot.newsnow.ui.home

import androidx.compose.animation.Crossfade
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.undabot.newsnow.ui.components.LoadingContent

@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {
  val state: HomeScreenState by viewModel.state.collectAsState()

  Crossfade(targetState = state.isLoading) { isLoading ->
    if (isLoading) {
      LoadingContent()
    } else {
      HomeScreenContent(state)
    }
  }
}
