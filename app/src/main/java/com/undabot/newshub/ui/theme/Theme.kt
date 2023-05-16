package com.undabot.newshub.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val LightColorScheme = lightColorScheme(
  primary = primary,
  secondary = primaryLight,

  /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun NewsHubTheme(
  content: @Composable () -> Unit,
) {

  val view = LocalView.current

  SideEffect {
    val window = (view.context as Activity).window

    window.statusBarColor = Color.Transparent.toArgb()
    window.navigationBarColor = Color.Transparent.toArgb()

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
      window.isNavigationBarContrastEnforced = false
    }

    val windowsInsetsController = WindowCompat.getInsetsController(window, view)

    windowsInsetsController.isAppearanceLightStatusBars = true
    windowsInsetsController.isAppearanceLightNavigationBars = true
  }

  MaterialTheme(
    colorScheme = LightColorScheme,
    typography = Typography,
    content = content,
  )
}
