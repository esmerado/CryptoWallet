package dev.jesmerado.cryptowallet.model

import android.graphics.Color
import androidx.annotation.DrawableRes

data class Stock(
    val company: String,
    @DrawableRes val icon: Int,
    val color: androidx.compose.ui.graphics.Color,
    val price: Double,
    val date: Long
)
