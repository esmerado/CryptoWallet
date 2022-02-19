package dev.jesmerado.cryptowallet.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import dev.jesmerado.cryptowallet.R
import dev.jesmerado.cryptowallet.navigation.Destinations

@Composable
fun LogoutButton() {
    Row(modifier = Modifier.fillMaxWidth().padding(top = 24.dp), horizontalArrangement = Arrangement.Center) {
        Button(
            modifier = Modifier
                .width(140.dp)
                .height(43.dp),
            onClick = { /*navController.navigate(Destinations.Login.route)*/ },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red)
        ) {
            Text(
                text = stringResource(R.string.logout),
                style = MaterialTheme.typography.h6.copy(
                    color = Color.White
                )
            )
        }
    }
}