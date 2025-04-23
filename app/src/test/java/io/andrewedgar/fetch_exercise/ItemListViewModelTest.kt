package io.andrewedgar.fetch_exercise

import io.andrewedgar.fetch_exercise.domain.Item
import io.andrewedgar.fetch_exercise.domain.Result
import io.andrewedgar.fetch_exercise.domain.interactors.ItemInteractor
import io.andrewedgar.fetch_exercise.ui.ItemListViewModel
import io.andrewedgar.fetch_exercise.ui.ItemsUiState
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito.mock
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever


@RunWith(JUnit4::class)
@ExperimentalCoroutinesApi
class ItemListViewModelTest {

    private lateinit var itemInteractor: ItemInteractor
    private lateinit var viewModel: ItemListViewModel
    private val testDispatcher = StandardTestDispatcher()


    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        itemInteractor = mock()
        viewModel = ItemListViewModel(itemInteractor)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `loadItems - Success - updates uiState with items`() = runTest(testDispatcher) {

        val expectedItems = listOf(Item(143, 1, " Item 1"), Item(143, 1, " Item 1"))
        whenever(itemInteractor.getItemsFromRemote()) doReturn Result.Success(expectedItems)


        viewModel.loadItems()


        val currentState = viewModel.uiState.value
        assertTrue(currentState is ItemsUiState.Success)
        assertEquals(expectedItems, (currentState as ItemsUiState.Success).items)


        verify(itemInteractor).getItemsFromRemote()
    }

    @Test
    fun `loadItems - Error - updates uiState with error message`() = runTest(testDispatcher) {

        val errorMessage = "Network error"
        val exception = IOException(errorMessage)
        whenever(itemInteractor.getItemsFromRemote()) doReturn Result.Error(exception)


        viewModel.loadItems()


        val currentState = viewModel.uiState.value
        assertTrue(currentState is ItemsUiState.Error)
        assertEquals(errorMessage, (currentState as ItemsUiState.Error).message)
        verify(itemInteractor).getItemsFromRemote()
    }

    @Test
    fun `initial state is Loading`() = runTest {
        val initialState = viewModel.uiState.value
        assertTrue(initialState is ItemsUiState.Loading)
        assertTrue((initialState as ItemsUiState.Loading).items.isEmpty())
    }
}