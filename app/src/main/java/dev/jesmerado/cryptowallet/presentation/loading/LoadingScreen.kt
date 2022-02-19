package dev.jesmerado.cryptowallet.presentation.loading

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import dev.jesmerado.cryptowallet.R
import dev.jesmerado.cryptowallet.navigation.Routes
import kotlinx.coroutines.delay

@Composable
fun LoadingScreen(navController: NavController) {
    Box(modifier = Modifier.fillMaxWidth().background(Color.White)) {
        val scale = remember {
            androidx.compose.animation.core.Animatable(0f)
        }

        // Animation
        LaunchedEffect(key1 = true) {
            scale.animateTo(
                targetValue = 0.7f,
                // tween Animation
                animationSpec = tween(
                    durationMillis = 800,
                    easing = {
                        OvershootInterpolator(4f).getInterpolation(it)
                    })
            )
            // Customize the delay time
            delay(2500L)
            navController.navigate(Routes.Main.route)
        }
        Column(
            modifier = Modifier.align(Alignment.Center).width(200.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,

        ) {
            Loader()
        }
    }
}

@Composable
fun Loader() {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.loading))
    val progress by animateLottieCompositionAsState(composition)
    LottieAnimation(composition, progress)
}