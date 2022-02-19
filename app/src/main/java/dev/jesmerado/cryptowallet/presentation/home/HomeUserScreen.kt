package dev.jesmerado.cryptowallet.presentation.home

import android.graphics.Bitmap
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import dev.jesmerado.cryptowallet.R
import dev.jesmerado.cryptowallet.presentation.components.LogoutButton
import dev.jesmerado.cryptowallet.presentation.components.StockList
import dev.jesmerado.cryptowallet.presentation.components.TopUserGraph

@ExperimentalMaterialApi
@Composable
fun HomeScreen(
    email: String,
    password: String
) {
    var isCameraSelected = false
    var imageUri: Uri? = null
    var bitmap: Bitmap? = null
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = BottomSheetState(BottomSheetValue.Collapsed)
    )
    val coroutineScope = rememberCoroutineScope()

    BottomSheetScaffold(
        scaffoldState = bottomSheetScaffoldState,
        sheetContent = {
            Box(
                Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.8f)
            ) {
                StockList()
            }
        },
        sheetShape = RoundedCornerShape(
            topStartPercent = 8,
            topEndPercent = 8
        ),
        sheetPeekHeight = LocalConfiguration.current.screenHeightDp.dp * 0.175f,
        sheetBackgroundColor = Color.Black,
    ) {
        Scaffold(
            topBar = { TopUserGraph(userMail = email) }
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceAround
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colors.background)
                        .padding(16.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Top
                    ) {
                        Text(
                            text = stringResource(id = R.string.user_screen),
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.h4,
                            modifier = Modifier.padding(bottom = 24.dp)
                        )

                        Image(
                            painter = painterResource(id = R.drawable.ic_undraw_thought_process),
                            contentDescription = "Login Image",
                            contentScale = ContentScale.Inside
                        )

                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .padding(24.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                            Text(text = stringResource(id = R.string.email))
                            Text(text = email)
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(24.dp), horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(text = stringResource(id = R.string.password))
                            Text(text = password)
                        }

                        LogoutButton()

                        Box(modifier = Modifier.fillMaxWidth())
                    }
                }
                /*UserDetails(email = email, password = password)*/


            }
        }
    }
}