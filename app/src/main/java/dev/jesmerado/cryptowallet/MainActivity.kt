package dev.jesmerado.cryptowallet

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.launch
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import dev.jesmerado.cryptowallet.navigation.Routes
import dev.jesmerado.cryptowallet.presentation.loading.LoadingScreen
import dev.jesmerado.cryptowallet.presentation.navigation.NavigationComponents
import dev.jesmerado.cryptowallet.ui.theme.CryptoWalletTheme
import kotlinx.coroutines.launch
import org.json.JSONArray

@ExperimentalMaterialApi
@AndroidEntryPoint
@ExperimentalAnimationApi
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val points = parse(this)
        val randomStartPoint = points.shuffled().first()

        setContent {
            CryptoWalletTheme {
                Surface(color = MaterialTheme.colors.background) {

                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = "splash_screen") {
                        composable(Routes.Splash.route) {
                            LoadingScreen(navController)
                        }
                        composable(Routes.Main.route) {
                            NavigationComponents(points = points, randomStartPoint = randomStartPoint)
                        }
                    }
                }
            }
        }
    }
}

private fun parse(context: Context): List<Offset> {
    val json = context.assets.open("coordinator.json").bufferedReader().use { it.readLine() }
    val array = JSONArray(json)
    val points = mutableListOf<Offset>()

    for (i in 0 until array.length()) {
        val coordinate = array.optJSONArray(i)
        val x = coordinate.optDouble(0).toFloat()
        val y = coordinate.optDouble(1).toFloat()
        points += Offset(x, y)
    }

    return points
}