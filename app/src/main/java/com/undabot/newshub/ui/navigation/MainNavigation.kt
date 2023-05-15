package com.undabot.newshub.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.undabot.newshub.ui.articleDetails.ArticleDetailsScreen
import com.undabot.newshub.ui.home.HomeScreen

@Composable
fun MainNavigation() {

  val navController = rememberNavController()

  NavHost(navController = navController, startDestination = "home") {
    composable(route = "home") {
      HomeScreen(
        navigateToArticleDetails = {
          navController.navigate("articleDetails/$it")
        },
      )
    }
    composable(
      route = "articleDetails/{articleId}",
      arguments = listOf(navArgument("articleId") { type = NavType.StringType })
    ) { backStackEntry ->
      ArticleDetailsScreen(backStackEntry.arguments?.getString("articleId")!!)
    }
  }
}
