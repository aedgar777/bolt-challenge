package io.andrewedgar.bolt_exercise.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import io.andrewedgar.bolt_exercise.ui.navigation.AppRoutes


@Composable
fun HomeScreen(navController: NavController
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button( onClick = { navController.navigate(AppRoutes.CLASSES) }) {
            Text(text = "Classes")
        }
        Button( onClick = { navController.navigate(AppRoutes.FEATURES) }) {
            Text(text = "Features")
        }

        Button( onClick = { navController.navigate(AppRoutes.MONSTERS) }) {
            Text(text = "Monsters")
        }

        Button( onClick = { navController.navigate(AppRoutes.SPELLS) }) {
            Text(text = "Spells")
        }




    }
}