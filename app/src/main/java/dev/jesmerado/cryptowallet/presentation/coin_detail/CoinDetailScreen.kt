package dev.jesmerado.cryptowallet.presentation.coin_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.accompanist.flowlayout.FlowRow
import com.jesmerado.appcompact.presentation.coin_detail.components.CoinTag
import dev.jesmerado.cryptowallet.presentation.coin_detail.components.TeamListItem
import dev.jesmerado.cryptowallet.presentation.Screen
import dev.jesmerado.cryptowallet.presentation.components.StockCoinPrice
import dev.jesmerado.cryptowallet.presentation.components.StockGraph
import dev.jesmerado.cryptowallet.presentation.components.TopGraph

@Composable
fun CoinDetailScreen(
    viewModel: CoinDetailViewModel = hiltViewModel(),
    navController: NavController,
    randomStartPoint: Offset,
    points: List<Offset>,
    date: String
) {
    val state = viewModel.state.value

    val bottomSheetPeekHeight = remember { mutableStateOf(130.dp) }

    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            state.coin?.let { coin ->
                TopGraph(navController, coin.name)

                StockCoinPrice(date = date, coin.rank.toString(), coin.symbol)

                StockGraph(points = points, randomStartPoint = randomStartPoint, months = months)

                Box(modifier = Modifier.fillMaxWidth().height(bottomSheetPeekHeight.value))
            }
        }

    }
}

private val months = listOf(
    "Jan",
    "Feb",
    "Mar",
    "Apr",
    "May",
    "Jun",
    "Jul",
    "Aug",
    "Sep",
    "Oct",
    "Nov",
    "Dec"
)