package dev.jesmerado.cryptowallet.presentation.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import dev.jesmerado.cryptowallet.R
import dev.jesmerado.cryptowallet.navigation.BottomNavItem
import dev.jesmerado.cryptowallet.navigation.Destinations
import dev.jesmerado.cryptowallet.presentation.home.HomeScreen
import dev.jesmerado.cryptowallet.presentation.login.LoginScreen
import dev.jesmerado.cryptowallet.presentation.login.LoginViewModel
import dev.jesmerado.cryptowallet.presentation.registration.RegisterViewModel
import dev.jesmerado.cryptowallet.presentation.registration.RegistrationScreen

@ExperimentalMaterialApi
@ExperimentalAnimationApi
@Composable
fun NavigationComponents(randomStartPoint: Offset, points: List<Offset>) {
    Row(verticalAlignment = Alignment.Bottom) {
        Column(modifier = Modifier.fillMaxSize()) {
            val navController = rememberNavController()
            Scaffold(
                bottomBar = { BottomNavigation(navController = navController) }
            ) {

                NavigationGraph(navController = navController, randomStartPoint, points)
            }
        }
    }
}

@ExperimentalMaterialApi
@ExperimentalAnimationApi
@Composable
fun LoginComponentScreen() {
    val navController = rememberAnimatedNavController()

    BoxWithConstraints {
        AnimatedNavHost(
            navController = navController,
            startDestination = Destinations.Login.route
        ) {
            addLogin(navController)

            addRegister(navController)

            addHome()
        }
    }
}

@ExperimentalAnimationApi
fun NavGraphBuilder.addLogin(
    navController: NavHostController
) {
    composable(
        route = Destinations.Login.route,
        enterTransition = { _, _ ->
            slideInHorizontally(
                initialOffsetX = { 1000 },
                animationSpec = tween(500)
            )
        },
        exitTransition = { _, _ ->
            slideOutHorizontally(
                targetOffsetX = { -1000 },
                animationSpec = tween(500)
            )
        },
        popEnterTransition = { _, _ ->
            slideInHorizontally(
                initialOffsetX = { -1000 },
                animationSpec = tween(500)
            )
        },
        popExitTransition = { _, _ ->
            slideOutHorizontally(
                targetOffsetX = { 1000 },
                animationSpec = tween(500)
            )
        }
    ) {
        val viewModel: LoginViewModel = hiltViewModel()
        val email = viewModel.state.value.email
        val password = viewModel.state.value.password

        if (viewModel.state.value.successLogin) {
            LaunchedEffect(key1 = Unit) {
                navController.navigate(
                    Destinations.Home.route + "/$email" + "/$password"
                ) {
                    popUpTo(Destinations.Login.route) {
                        inclusive = true
                    }
                }
            }
        } else {
            LoginScreen(
                state = viewModel.state.value,
                onLogin = viewModel::login,
                onNavigateToRegister = {
                    navController.navigate(Destinations.Register.route)
                },
                onDismissDialog = viewModel::hideErrorDialog
            )
        }
    }
}

@ExperimentalAnimationApi
fun NavGraphBuilder.addRegister(
    navController: NavHostController
) {
    composable(
        route = Destinations.Register.route,
        enterTransition = { _, _ ->
            slideInHorizontally(
                initialOffsetX = { 1000 },
                animationSpec = tween(500)
            )
        },
        exitTransition = { _, _ ->
            slideOutHorizontally(
                targetOffsetX = { -1000 },
                animationSpec = tween(500)
            )
        },
        popEnterTransition = { _, _ ->
            slideInHorizontally(
                initialOffsetX = { -1000 },
                animationSpec = tween(500)
            )
        },
        popExitTransition = { _, _ ->
            slideOutHorizontally(
                targetOffsetX = { 1000 },
                animationSpec = tween(500)
            )
        }
    ) {
        val viewModel: RegisterViewModel = hiltViewModel()

        RegistrationScreen(
            state = viewModel.state.value,
            onRegister = viewModel::register,
            onBack = {
                navController.popBackStack()
            },
            onDismissDialog = viewModel::hideErrorDialog
        )
    }
}

@ExperimentalMaterialApi
@ExperimentalAnimationApi
fun NavGraphBuilder.addHome() {
    composable(
        route = Destinations.Home.route + "/{email}" + "/{password}",
        arguments = Destinations.Home.arguments
    ) { backStackEntry ->

        val email = backStackEntry.arguments?.getString("email") ?: ""
        val password = backStackEntry.arguments?.getString("password") ?: ""

        HomeScreen(email, password)
    }
}

@Composable
fun BottomNavigation(navController: NavController) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.User
    )
    androidx.compose.material.BottomNavigation(
        backgroundColor = colorResource(id = R.color.dark_blue),
        contentColor = Color.White
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.title) },

                selectedContentColor = Color.White,
                unselectedContentColor = Color.White.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == item.screen_route,
                onClick = {
                    navController.navigate(item.screen_route) {

                        navController.graph.startDestinationRoute?.let { screen_route ->
                            popUpTo(screen_route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}
