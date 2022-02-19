package dev.jesmerado.cryptowallet.presentation.coin_detail

import dev.jesmerado.cryptowallet.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
