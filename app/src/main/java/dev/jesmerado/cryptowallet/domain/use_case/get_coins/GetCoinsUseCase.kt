package dev.jesmerado.cryptowallet.domain.use_case.get_coins

import dev.jesmerado.cryptowallet.common.Resource
import dev.jesmerado.cryptowallet.data.remote.dto.toCoin
import dev.jesmerado.cryptowallet.domain.model.Coin
import dev.jesmerado.cryptowallet.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val respository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = respository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))
        } catch (e: HttpException) {
            // TODO: add exception
        } catch (e: IOException) {
            // TODO: add exception
        }
    }
}