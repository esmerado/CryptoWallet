package dev.jesmerado.cryptowallet.navigation

sealed class Routes(val route: String) {
    object Main : Routes("main_screen")
    object Splash : Routes("splash_screen")
    object User : Routes("user_screen")
}