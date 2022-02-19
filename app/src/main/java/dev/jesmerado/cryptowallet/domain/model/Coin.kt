package dev.jesmerado.cryptowallet.domain.model

/**
 * This Data Class is going to have all the data we are gonna use from de CoinDto.
 */
data class Coin(
    val id: String,
    val isActive: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
)
