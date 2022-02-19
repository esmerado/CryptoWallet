package dev.jesmerado.cryptowallet.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.jesmerado.cryptowallet.R

@Composable
fun StockCoinPrice(
    date: String,
    rank: String,
    symbol: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        Text(
            text = " #$rank $symbol",
            style = TextStyle(
                color = MaterialTheme.colors.onSurface,
                fontStyle = FontStyle.Normal,
                fontSize = 20.sp
            )
        )

        Text(
            text = "$1893.54",
            style = TextStyle(
                color = MaterialTheme.colors.onSurface,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Black,
                fontSize = 28.sp
            )
        )

        Text(
            text = date,
            style = TextStyle(
                color = LightGray,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp
            )
        )
    }
}