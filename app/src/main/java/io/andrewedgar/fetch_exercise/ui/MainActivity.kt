package io.andrewedgar.fetch_exercise.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import io.andrewedgar.fetch_exercise.ui.screens.listscreen.ItemList
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val itemViewModel: ItemListViewModel by viewModel()
            val uiState: ItemsUiState by itemViewModel.uiState.collectAsState()

            Column(
                modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {

                when (uiState) {
                    is ItemsUiState.Loading -> CircularProgressIndicator()

                    is ItemsUiState.Success -> ItemList((uiState as ItemsUiState.Success).items)

                    is ItemsUiState.Error -> Text((uiState as ItemsUiState.Error).message.toString())

                }
            }

            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.Bottom,
            ){
                Button(onClick = {itemViewModel.fetchDbItemsById(1)}){
                    Text(text = "1")
                }
                Button(onClick = {itemViewModel.fetchDbItemsById(2)}){
                    Text(text = "2")
                }
                Button(onClick = {itemViewModel.fetchDbItemsById(3)}){
                    Text(text = "3 ")
                }
                Button(onClick = {itemViewModel.loadItems()}){
                    Text(text = "Refresh")
                }
            }

        }
    }
}