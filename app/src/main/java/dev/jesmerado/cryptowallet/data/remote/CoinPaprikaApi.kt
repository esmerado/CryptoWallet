package dev.jesmerado.cryptowallet.data.remote

import dev.jesmerado.cryptowallet.data.remote.dto.CoinDetailDto
import dev.jesmerado.cryptowallet.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinByID(@Path("coinId") coinId: String): CoinDetailDto
}