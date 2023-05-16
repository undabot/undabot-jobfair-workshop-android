package com.undabot.newshub.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.undabot.newshub.R
import com.undabot.newshub.domain.model.Article
import com.undabot.newshub.domain.model.Source
import com.undabot.newshub.ui.components.NetworkImage
import com.undabot.newshub.ui.components.SourceButton

@Composable
fun HomeScreenContent(
  state: HomeScreenState,
  onSourceClick: (Source) -> Unit,
  onArticleClick: (Article) -> Unit,
) {
  LazyColumn(
    modifier = Modifier.fillMaxSize(),
    contentPadding = PaddingValues(vertical = 16.dp),
    verticalArrangement = Arrangement.spacedBy(16.dp),
  ) {
    item {
      Text(
        modifier = Modifier
          .statusBarsPadding()
          .padding(21.dp),
        text = stringResource(id = R.string.app_name),
        style = MaterialTheme.typography.titleLarge,
      )
    }
    item {
      LazyRow(
        modifier = Modifier
          .padding(bottom = 8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
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
      ArticleCard(
        article = article,
        onClick = { onArticleClick(article) },
      )
    }
  }
}

@Composable
private fun ArticleCard(article: Article, onClick: () -> Unit) {
  Box(
    modifier = Modifier
      .padding(horizontal = 16.dp)
      .shadow(
        elevation = 3.dp,
        shape = RoundedCornerShape(8.dp),
      )
      .background(MaterialTheme.colorScheme.surface)
      .clickable(onClick = onClick),
  ) {
    Row(
      modifier = Modifier.padding(16.dp)
    ) {
      NetworkImage(
        modifier = Modifier.size(96.dp),
        url = article.urlToImage,
      )
      Column(
        modifier = Modifier.padding(start = 16.dp)
      ) {
        Text(
          text = article.title,
          style = MaterialTheme.typography.titleSmall,
          maxLines = 2,
          overflow = TextOverflow.Ellipsis,
        )
        Text(
          modifier = Modifier.padding(2.dp),
          text = article.description,
          style = MaterialTheme.typography.bodySmall,
          maxLines = 3,
          overflow = TextOverflow.Ellipsis,
        )
      }
    }
  }
}
