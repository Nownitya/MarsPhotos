package com.nowni.marsphotos.fake

import com.nowni.marsphotos.rules.TestDispatcherRule
import com.nowni.marsphotos.ui.screens.MarsUiState
import com.nowni.marsphotos.ui.screens.MarsViewModel
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class MarsViewModelTest {

    @get:Rule
    val dispatcher= TestDispatcherRule()

    @Test
    fun marsViewModel_getMarsPhotos_verifyMarsUiStateSuccess() {
        runTest {
            val marsViewModel = MarsViewModel(
                marsPhotosRepository = FakeNetworkMarsPhotosRepository()
            )
            assertEquals(
                MarsUiState.Success(
                    FakeDataSource.photosList
                ),
                marsViewModel.marsUiState
            )
        }
    }
}