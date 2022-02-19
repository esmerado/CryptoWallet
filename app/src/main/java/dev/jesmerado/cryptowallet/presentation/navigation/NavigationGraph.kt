package dev.jesmerado.cryptowallet.presentation.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import dev.jesmerado.cryptowallet.navigation.BottomNavItem
import dev.jesmerado.cryptowallet.presentation.HomeScreen
import dev.jesmerado.cryptowallet.presentation.TrendScreen
import dev.jesmerado.cryptowallet.presentation.UserScreen

@ExperimentalMaterialApi
@ExperimentalAnimationApi
@Composable
fun NavigationGraph(
    navController: NavHostController,
    randomStartPoint: Offset,
    points: List<Offset>
) {
    NavHost(navController, startDestination = BottomNavItem.Home.screen_route) {
        composable(BottomNavItem.Home.screen_route) {
            HomeScreen(randomStartPoint, points)
        }
        composable(BottomNavItem.User.screen_route) {
            UserScreen()
        }
        composable(BottomNavItem.Trend.screen_route) {
            TrendScreen()
        }
    }
}