package io.andrewedgar.bolt_exercise.ui.screens.featurelistscreen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import io.andrewedgar.bolt_exercise.domain.models.Feature
import io.andrewedgar.bolt_exercise.domain.models.Monster
import io.andrewedgar.bolt_exercise.ui.screens.monsterscreen.MonsterListItemView

@Composable
fun FeatureListView(featureList: List<Feature>) {

    LazyColumn {
        items(featureList.size) { index ->
            FeatureListItemView(featureList[index])
        }
    }
}