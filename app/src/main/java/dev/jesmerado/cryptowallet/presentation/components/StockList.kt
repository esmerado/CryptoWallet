package dev.jesmerado.cryptowallet.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.jesmerado.cryptowallet.model.Stock
import dev.jesmerado.cryptowallet.R
import dev.jesmerado.cryptowallet.ui.theme.*
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun StockList() {
    val time = System.currentTimeMillis()
    val dateFormat = SimpleDateFormat("MMMM dd, yyyy", Locale.ROOT)
    val date = dateFormat.format(time).capitalize(Locale.ROOT)
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
            .padding(16.dp)
    ) {
        Divider(
            modifier = Modifier
                .width(42.dp)
                .padding(top = 8.dp, bottom = 16.dp)
                .clip(CircleShape)
                .align(Alignment.CenterHorizontally),
            thickness = 3.dp,
            color = Color.White
        )

        Text(
            text = "Wallet",
            modifier = Modifier
                .fillMaxWidth(),
            style = TextStyle(
                color = Color.White,
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp
            )
        )

        StockPrice(date = date)

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(stocks) {
                StockItem(it)
            }
        }
    }
}

private val stocks = listOf(
    Stock(
        company = "Bitcoin",
        icon = R.drawable.ic_bx_bitcoin,
        color = BITCOIN,
        price = 75.43,
        date = System.currentTimeMillis()
    ),
    Stock(
        company = "Meta",
        icon = R.drawable.ic_bxl_meta,
        color = FACEBOOKCOLOR,
        price = -120.60,
        date = System.currentTimeMillis()
    ),
    Stock(
        company = "Amazon",
        icon = R.drawable.ic_bxl_amazon,
        color = AMAZON,
        price = 90.32,
        date = System.currentTimeMillis()
    )
)