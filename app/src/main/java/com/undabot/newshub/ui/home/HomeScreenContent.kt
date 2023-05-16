package com.undabot.newshub.ui.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.undabot.newshub.domain.model.Article
import com.undabot.newshub.domain.model.Source

@Composable
fun HomeScreenContent(
  state: HomeScreenState,
  onSourceClick: (Source) -> Unit,
  onArticleClick: (Article) -> Unit,
) {
  LazyColumn(
    modifier = Modifier.fillMaxSize(),
  ) {
    item {
      LazyRow() {
        items(state.availableSources) { source ->
          // TODO render source
        }
      }
    }
    items(state.articles) { article ->
      // TODO render article
    }
  }
}
