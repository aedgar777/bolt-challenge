package io.andrewedgar.bolt_exercise.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.andrewedgar.bolt_exercise.domain.Item
import io.andrewedgar.bolt_exercise.domain.Result
import io.andrewedgar.bolt_exercise.domain.interactors.ItemInteractor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class ItemListViewModel(private val itemInteractor: ItemInteractor) : ViewModel(), CoroutineScope {
    private val job = Job()
    override val coroutineContext: CoroutineContext = Dispatchers.IO + job
    private val _uiState = MutableStateFlow<ItemsUiState>(ItemsUiState.Loading(emptyList()))

    val uiState: StateFlow<ItemsUiState> = _uiState.asStateFlow()


    init {
        loadItems()
    }

    fun loadItems() {

        _uiState.value = ItemsUiState.Loading(emptyList())
        viewModelScope.launch(coroutineContext) {
                val result = itemInteractor.getItemsFromRemote()

                _uiState.value = when (result) {
                    is Result.Success -> ItemsUiState.Success(result.data)
                    is Result.Error -> ItemsUiState.Error(result.exception.message)
                }

            if (_uiState.value is ItemsUiState.Success) {
                val successState = _uiState.value as ItemsUiState.Success
                itemInteractor.saveItemsToLocal(successState.items)
            }
            }
    }


    fun fetchDbItemsById(id: Int) {

        viewModelScope.launch {
           val result = itemInteractor.getItemsFromLocalByListId(id)
            if (result.isNotEmpty()) {
                _uiState.value = ItemsUiState.Success(result)
            } else {
                _uiState.value = ItemsUiState.Error("No items found")
            }
        }



    }
}

sealed class ItemsUiState{
    data class Loading(val items: List<Item>) : ItemsUiState()
    data class Success(val items: List<Item>) : ItemsUiState()
    data class Error(val message: String?) : ItemsUiState()
}

