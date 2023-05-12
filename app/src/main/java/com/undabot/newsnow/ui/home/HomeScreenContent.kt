package com.undabot.newsnow.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.undabot.newsnow.domain.model.Article

@Composable
fun HomeScreenContent(state: HomeScreenState) {
  LazyColumn(
    modifier = Modifier.fillMaxSize(),
  ) {
    items(state.articles) { article ->
      ArticleCard(article)
    }
  }
}

@Composable
private fun ArticleCard(article: Article) {
  Card(
    modifier = Modifier.padding(16.dp),
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
