package io.andrewedgar.bolt_exercise.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.andrewedgar.bolt_exercise.domain.Result
import io.andrewedgar.bolt_exercise.domain.interactors.DndInteractor
import io.andrewedgar.bolt_exercise.domain.models.Feature
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class FeatureListViewModel(private val dndInteractor: DndInteractor) : ViewModel(), CoroutineScope {
    private val job = Job()
    override val coroutineContext: CoroutineContext = Dispatchers.IO + job
    private val _uiState = MutableStateFlow<FeatureListUiState>(FeatureListUiState.Loading(emptyList()))

    val uiState: StateFlow<FeatureListUiState> = _uiState.asStateFlow()


    init {
        loadFeatures()
    }

    fun loadFeatures() {

        _uiState.value = FeatureListUiState.Loading(emptyList())
        viewModelScope.launch(coroutineContext) {
                val result = dndInteractor.getFeatures()

                _uiState.value = when (result) {
                    is Result.Success -> FeatureListUiState.Success(result.data)
                    is Result.Error -> FeatureListUiState.Error(result.exception.message)
                }
            }
    }


}

sealed class FeatureListUiState{
    data class Loading(val items: List<Feature>) : FeatureListUiState()
    data class Success(val items: List<Feature>) : FeatureListUiState()
    data class Error(val message: String?) : FeatureListUiState()
}

