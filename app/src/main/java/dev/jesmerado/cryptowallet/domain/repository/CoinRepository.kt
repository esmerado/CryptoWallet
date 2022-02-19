package dev.jesmerado.cryptowallet.domain.repository

import dev.jesmerado.cryptowallet.data.remote.dto.CoinDetailDto
import dev.jesmerado.cryptowallet.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto

}