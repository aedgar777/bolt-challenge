package io.andrewedgar.bolt_exercise.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.andrewedgar.bolt_exercise.domain.Result
import io.andrewedgar.bolt_exercise.domain.interactors.DndInteractor
import io.andrewedgar.bolt_exercise.domain.models.Monster
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class MonsterListViewModel(private val dndInteractor: DndInteractor) : ViewModel(), CoroutineScope {
    private val job = Job()
    override val coroutineContext: CoroutineContext = Dispatchers.IO + job
    private val _uiState = MutableStateFlow<MonsterListUiState>(MonsterListUiState.Loading(emptyList()))

    val uiState: StateFlow<MonsterListUiState> = _uiState.asStateFlow()


    init {
        loadMonsters()
    }

    fun loadMonsters() {

        _uiState.value = MonsterListUiState.Loading(emptyList())
        viewModelScope.launch(coroutineContext) {
                val result = dndInteractor.getMonsters()

                _uiState.value = when (result) {
                    is Result.Success -> MonsterListUiState.Success(result.data)
                    is Result.Error -> MonsterListUiState.Error(result.exception.message)
                }
            }
    }


}

sealed class MonsterListUiState{
    data class Loading(val items: List<Monster>) : MonsterListUiState()
    data class Success(val items: List<Monster>) : MonsterListUiState()
    data class Error(val message: String?) : MonsterListUiState()
}

