package dev.jesmerado.cryptowallet.presentation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.jesmerado.cryptowallet.presentation.coin_detail.CoinDetailScreen
import dev.jesmerado.cryptowallet.presentation.coin_list.CoinListScreen
import dev.jesmerado.cryptowallet.presentation.navigation.LoginComponentScreen
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun TrendScreen(names: List<String> = List(1000) { "$it" }) {

    Text(text = "Trend")

}

@Composable
fun HomeScreen(randomStartPoint: Offset, points: List<Offset>) {
    val navController = rememberNavController()
    val time = System.currentTimeMillis()
    val dateFormat = SimpleDateFormat("MMMM dd, yyyy", Locale.ROOT)
    val date = dateFormat.format(time).capitalize(Locale.ROOT)

    NavHost(
        navController = navController,
        startDestination = Screen.CoinListScreen.route
    ) {
        composable(route = Screen.CoinListScreen.route) {
            CoinListScreen(navController = navController)
        }
        composable(route = Screen.CoinDetailScreen.route + "/{coinId}") {
            CoinDetailScreen(navController = navController, randomStartPoint = randomStartPoint,
                points = points, date = date)
        }
    }
}

@ExperimentalMaterialApi
@ExperimentalAnimationApi
@Composable
fun UserScreen() {
    LoginComponentScreen()
}