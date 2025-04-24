package io.andrewedgar.bolt_exercise.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.andrewedgar.bolt_exercise.domain.Result
import io.andrewedgar.bolt_exercise.domain.interactors.DndInteractor
import io.andrewedgar.bolt_exercise.domain.models.Spell
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class SpellListViewModel(private val dndInteractor: DndInteractor) : ViewModel(), CoroutineScope {
    private val job = Job()
    override val coroutineContext: CoroutineContext = Dispatchers.IO + job
    private val _uiState = MutableStateFlow<SpellListUiState>(SpellListUiState.Loading(emptyList()))

    val uiState: StateFlow<SpellListUiState> = _uiState.asStateFlow()


    init {
        loadSpells()
    }

    fun loadSpells() {

        _uiState.value = SpellListUiState.Loading(emptyList())
        viewModelScope.launch(coroutineContext) {
                val result = dndInteractor.getSpells()

                _uiState.value = when (result) {
                    is Result.Success -> SpellListUiState.Success(result.data)
                    is Result.Error -> SpellListUiState.Error(result.exception.message)
                }
            }
    }


}

sealed class SpellListUiState{
    data class Loading(val items: List<Spell>) : SpellListUiState()
    data class Success(val items: List<Spell>) : SpellListUiState()
    data class Error(val message: String?) : SpellListUiState()
}

