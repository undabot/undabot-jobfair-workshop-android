package com.undabot.newshub.ui.articleDetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.undabot.newshub.R
import com.undabot.newshub.domain.model.Article
import com.undabot.newshub.ui.components.NetworkImage
import com.undabot.newshub.ui.components.SourceButton

@Composable
fun ArticleDetailsScreenContent(article: Article) {
  Column {
    Box(
      contentAlignment = Alignment.BottomStart,
    ) {
      NetworkImage(
        modifier = Modifier
          .fillMaxWidth()
          .height(280.dp),
        url = article.urlToImage,
      )
      ImageGradient()
      if (article.source != null) {
        SourceButton(
          modifier = Modifier.padding(horizontal = 20.dp, vertical = 24.dp),
          source = article.source,
          isSelected = true,
          onClick = null,
        )
      }
    }
    Text(
      modifier = Modifier.padding(horizontal = 20.dp),
      text = article.title,
      style = MaterialTheme.typography.titleLarge,
    )
    Row(
      modifier = Modifier.padding(top = 8.dp, start = 20.dp),
      verticalAlignment = Alignment.CenterVertically,
    ) {
      Icon(
        painter = painterResource(id = R.drawable.ic_author),
        contentDescription = null,
      )
      Text(
        modifier = Modifier.padding(start = 11.dp),
        text = article.author,
        style = MaterialTheme.typography.headlineSmall,
      )
    }
    Text(
      modifier = Modifier
        .padding(top = 16.dp)
        .padding(horizontal = 20.dp),
      text = article.description,
      style = MaterialTheme.typography.bodySmall,
    )
    Text(
      modifier = Modifier
        .padding(top = 16.dp)
        .padding(horizontal = 20.dp),
      text = article.content,
      style = MaterialTheme.typography.bodySmall,
    )
  }
}

@Composable
private fun ImageGradient() {
  Box(
    modifier = Modifier
      .fillMaxWidth()
      .height(120.dp)
      .background(
        brush = Brush.verticalGradient(
          colors = listOf(Color.Transparent, Color.White),
        )
      ),
  )
}
