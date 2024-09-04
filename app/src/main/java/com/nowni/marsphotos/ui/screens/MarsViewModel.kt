package com.nowni.marsphotos.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import coil.network.HttpException
import com.nowni.marsphotos.MarsPhotosApplication
import com.nowni.marsphotos.data.MarsPhotosRepository
import com.nowni.marsphotos.model.MarsPhoto
import kotlinx.coroutines.launch
import okio.IOException

sealed interface MarsUiState {
    data class Success(val photos: List<MarsPhoto>) : MarsUiState
    object Loading : MarsUiState
    object Error : MarsUiState

}

class MarsViewModel(private val marsPhotosRepository:MarsPhotosRepository) : ViewModel() {

    var marsUiState: MarsUiState by mutableStateOf(MarsUiState.Loading)
        private set

    init {
        getMarPhotos()
    }

    fun getMarPhotos() {
        viewModelScope.launch {
            marsUiState = try {
                val listResult = marsPhotosRepository.getMarsPhotos()
                MarsUiState.Success(
                    /*"Success: ${listResult.size} Mars photos retrieved"*/
                    /*  "  First Mars Image URL: ${listResult.imgSrc} "*/
                    listResult
                )
            } catch (e: IOException) {
                MarsUiState.Error
            } catch (e: HttpException) {
                MarsUiState.Error
            }
        }
    }

    companion object {
        val Factory :ViewModelProvider.Factory= viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as MarsPhotosApplication)
                val marsPhotosRepository = application.container.marsPhotosRepository
                MarsViewModel(marsPhotosRepository=marsPhotosRepository)
            }
        }
    }

}

