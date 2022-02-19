package dev.jesmerado.cryptowallet.navigation

import dev.jesmerado.cryptowallet.R

sealed class BottomNavItem(var title:String, var icon:Int, var screen_route:String){

    object Home : BottomNavItem("Home", R.drawable.ic_bxl_bitcoin,"home")
    object Trend: BottomNavItem("Trend", R.drawable.ic_bx_trending_up,"trend")
    object User: BottomNavItem("User", R.drawable.ic_bxs_user,"user")
}