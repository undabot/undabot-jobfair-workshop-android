package com.undabot.newshub.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import com.bumptech.glide.integration.compose.GlideImage

@Composable
fun NetworkImage(
  modifier: Modifier = Modifier,
  url: String = "",
) {
  GlideImage(
    modifier = modifier,
    model = url,
    contentDescription = null,
    contentScale = ContentScale.Crop,
  )
}
