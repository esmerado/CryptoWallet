package dev.jesmerado.cryptowallet.data.repository

import dev.jesmerado.cryptowallet.data.remote.CoinPaprikaApi
import dev.jesmerado.cryptowallet.data.remote.dto.CoinDetailDto
import dev.jesmerado.cryptowallet.data.remote.dto.CoinDto
import dev.jesmerado.cryptowallet.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinByID(coinId)
    }
}