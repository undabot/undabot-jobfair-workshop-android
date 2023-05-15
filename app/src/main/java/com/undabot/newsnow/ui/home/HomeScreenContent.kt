package com.undabot.newsnow.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import com.undabot.newsnow.domain.model.Article
import com.undabot.newsnow.domain.model.Source

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
      LazyRow(
        modifier = Modifier
          .statusBarsPadding()
          .padding(top = 30.dp),
      ) {
        items(state.availableSources) { source ->
          SourceButton(
            source = source,
            isSelected = state.currentSource == source,
            onClick = { onSourceClick(source) },
          )
        }
      }
    }
    items(state.articles) { article ->
      ArticleCard(article)
    }
  }
}

@Composable
private fun ArticleCard(article: Article) {
  Box(
    modifier = Modifier
      .padding(
        top = 16.dp,
        start = 16.dp,
        end = 16.dp,
      )
      .shadow(
        elevation = 3.dp,
        shape = RoundedCornerShape(8.dp),
      )
      .background(MaterialTheme.colorScheme.surface),
  ) {
    Column(
      modifier = Modifier.padding(16.dp),
    ) {
      Text(text = article.title)
      Spacer(modifier = Modifier.height(8.dp))
      Text(text = article.description)
    }
  }
}

@Composable
private fun SourceButton(
  source: Source,
  isSelected: Boolean,
  onClick: () -> Unit,
) {
  Box(
    modifier = Modifier
      .padding(
        start = 16.dp,
      )
      .clip(RoundedCornerShape(8.dp))
      .background(
        color = if (isSelected) {
          MaterialTheme.colorScheme.primary
        } else {
          MaterialTheme.colorScheme.secondary
        },
      )
      .clickable(onClick = onClick),
  ) {
    Text(
      modifier = Modifier.padding(
        vertical = 6.dp,
        horizontal = 12.dp,
      ),
      text = source.name,
      style = if (isSelected) {
        MaterialTheme.typography.labelMedium
      } else {
        MaterialTheme.typography.labelSmall
      },
    )
  }
}
