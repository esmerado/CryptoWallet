package dev.jesmerado.cryptowallet.domain.use_case.get_coin

import dev.jesmerado.cryptowallet.common.Resource
import dev.jesmerado.cryptowallet.data.remote.dto.toCoinDetail
import dev.jesmerado.cryptowallet.domain.model.CoinDetail
import dev.jesmerado.cryptowallet.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val respository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coin = respository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coin))
        } catch (e: HttpException){
            // TODO: add exception
        } catch (e: IOException) {
            // TODO: add exception
        }
    }
}