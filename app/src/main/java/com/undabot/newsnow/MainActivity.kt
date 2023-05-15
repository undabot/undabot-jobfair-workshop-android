package com.undabot.newsnow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import com.undabot.newsnow.ui.home.HomeScreen
import com.undabot.newsnow.ui.theme.NewsNowTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    drawAppBehindSystemBars()

    setContent {
      NewsNowTheme {
        Surface(
          modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding(),
          color = MaterialTheme.colorScheme.background,
        ) {
          HomeScreen()
        }
      }
    }
  }

  private fun drawAppBehindSystemBars() {
    WindowCompat.setDecorFitsSystemWindows(window, false)
  }
}
