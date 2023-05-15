package com.undabot.newshub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import com.undabot.newshub.ui.navigation.MainNavigation
import com.undabot.newshub.ui.theme.NewsHubTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    drawAppBehindSystemBars()

    setContent {
      NewsHubTheme {
        Surface(
          modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding(),
          color = MaterialTheme.colorScheme.background,
        ) {
          MainNavigation()
        }
      }
    }
  }

  private fun drawAppBehindSystemBars() {
    WindowCompat.setDecorFitsSystemWindows(window, false)
  }
}
