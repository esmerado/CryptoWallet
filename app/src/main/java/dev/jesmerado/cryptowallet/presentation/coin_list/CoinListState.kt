package dev.jesmerado.cryptowallet.presentation.coin_list

import dev.jesmerado.cryptowallet.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
