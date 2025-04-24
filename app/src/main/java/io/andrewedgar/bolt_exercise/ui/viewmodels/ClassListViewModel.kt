package io.andrewedgar.bolt_exercise.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.andrewedgar.bolt_exercise.domain.models.CharacterClass
import io.andrewedgar.bolt_exercise.domain.Result
import io.andrewedgar.bolt_exercise.domain.interactors.DndInteractor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class ClassListViewModel(private val dndInteractor: DndInteractor) : ViewModel(), CoroutineScope {
    private val job = Job()
    override val coroutineContext: CoroutineContext = Dispatchers.IO + job
    private val _uiState = MutableStateFlow<ClassListUiState>(ClassListUiState.Loading(emptyList()))

    val uiState: StateFlow<ClassListUiState> = _uiState.asStateFlow()


    init {
        loadClasses()
    }

    fun loadClasses() {

        _uiState.value = ClassListUiState.Loading(emptyList())
        viewModelScope.launch(coroutineContext) {
                val result = dndInteractor.getClasses()

                _uiState.value = when (result) {
                    is Result.Success -> ClassListUiState.Success(result.data)
                    is Result.Error -> ClassListUiState.Error(result.exception.message)
                }
            }
    }


}

sealed class ClassListUiState{
    data class Loading(val items: List<CharacterClass>) : ClassListUiState()
    data class Success(val items: List<CharacterClass>) : ClassListUiState()
    data class Error(val message: String?) : ClassListUiState()
}

