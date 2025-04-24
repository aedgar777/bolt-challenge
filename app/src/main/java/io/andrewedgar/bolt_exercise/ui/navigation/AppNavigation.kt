package io.andrewedgar.bolt_exercise.ui.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.andrewedgar.bolt_exercise.ui.screens.HomeScreen
import io.andrewedgar.bolt_exercise.ui.screens.classlistscreen.ClassScreen
import io.andrewedgar.bolt_exercise.ui.screens.featurelistscreen.FeatureScreen
import io.andrewedgar.bolt_exercise.ui.screens.monsterscreen.MonsterScreen
import io.andrewedgar.bolt_exercise.ui.screens.spellscreen.SpellScreen
import io.andrewedgar.bolt_exercise.ui.viewmodels.ClassListViewModel
import io.andrewedgar.bolt_exercise.ui.viewmodels.FeatureListViewModel
import io.andrewedgar.bolt_exercise.ui.viewmodels.MonsterListViewModel
import io.andrewedgar.bolt_exercise.ui.viewmodels.SpellListViewModel
import org.koin.androidx.compose.koinViewModel

object AppRoutes{
    const val HOME = "home"
    const val CLASSES = "classes"
    const val FEATURES = "features"
    const val MONSTERS = "monsters"
    const val SPELLS = "spells"

}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = AppRoutes.HOME) {
        composable(AppRoutes.HOME) {
            HomeScreen(navController)
        }
        composable(AppRoutes.CLASSES) {
            val viewModel: ClassListViewModel = koinViewModel()
            val uiState = viewModel.uiState.collectAsStateWithLifecycle()
            ClassScreen(uiState.value)
        }
        composable(AppRoutes.FEATURES) {
            val viewModel: FeatureListViewModel = koinViewModel()
            val uiState = viewModel.uiState.collectAsStateWithLifecycle()
            FeatureScreen(uiState.value)
        }
        composable(AppRoutes.MONSTERS) {
            val viewModel: MonsterListViewModel = koinViewModel()
            val uiState = viewModel.uiState.collectAsStateWithLifecycle()
            MonsterScreen(uiState.value)
            }
        composable(AppRoutes.SPELLS) {
            val viewModel: SpellListViewModel = koinViewModel()
            val uiState = viewModel.uiState.collectAsStateWithLifecycle()
            SpellScreen(uiState.value)
        }

    }
}





