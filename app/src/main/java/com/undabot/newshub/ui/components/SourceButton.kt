package com.undabot.newshub.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.undabot.newshub.domain.model.Source

@Composable
fun SourceButton(
  source: Source,
  isSelected: Boolean,
  onClick: (() -> Unit)?,
  modifier: Modifier = Modifier,
) {
  Box(
    modifier = modifier
      .clip(RoundedCornerShape(8.dp))
      .background(
        color = if (isSelected) {
          MaterialTheme.colorScheme.primary
        } else {
          MaterialTheme.colorScheme.secondary
        },
      )
      .then(
        if (onClick != null) {
          Modifier.clickable(onClick = onClick)
        } else {
          Modifier
        }
      ),
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
