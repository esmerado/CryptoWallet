package dev.jesmerado.cryptowallet.data.remote.dto

import com.google.gson.annotations.SerializedName
import dev.jesmerado.cryptowallet.domain.model.Coin

/**
 * This class contains all the data that out api call is going to get.
 */
data class CoinDto(
    val id: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("is_new")
    val isNew: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)

// This function is gonna filter all the CoinDto data to the Coin data we want.
fun CoinDto.toCoin(): Coin {
    return Coin(
        id = id,
        isActive = isActive,
        name = name,
        rank = rank,
        symbol = symbol
        )
}