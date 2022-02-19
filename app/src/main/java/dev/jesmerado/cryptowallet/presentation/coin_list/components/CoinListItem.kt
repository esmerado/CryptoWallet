package dev.jesmerado.cryptowallet.presentation.coin_list.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import dev.jesmerado.cryptowallet.domain.model.Coin
import dev.jesmerado.cryptowallet.ui.theme.DarkBlue

@Composable
fun CoinListItem(
    coin: Coin,
    onItemClick: (Coin) -> Unit

) {
    Card(
        backgroundColor = Color.White,
        modifier = Modifier
            .padding(vertical = 4.dp, horizontal = 8.dp)
            .fillMaxWidth(),
            elevation = 5.dp,
        border = BorderStroke(1.dp, DarkBlue)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onItemClick(coin) }
                .padding(7.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(12.dp)
            ) {
                Text(
                    text = "${coin.rank}. ${coin.name} (${coin.symbol})",
                    style = MaterialTheme.typography.body1,
                    overflow = TextOverflow.Ellipsis
                )
            }

        }
    }

}