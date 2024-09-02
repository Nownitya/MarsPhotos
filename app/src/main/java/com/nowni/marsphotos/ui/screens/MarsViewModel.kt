package com.nowni.marsphotos.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nowni.marsphotos.network.MarsApi
import kotlinx.coroutines.launch
import okio.IOException

sealed interface MarsUiState {
    data class Success(val photos: String) : MarsUiState
    object Loading : MarsUiState
    object Error : MarsUiState

}

class MarsViewModel : ViewModel() {

    var marsUiState: MarsUiState by mutableStateOf(MarsUiState.Loading)
        private set

    init {
        getMarPhotos()
    }

    private fun getMarPhotos() {
//        marsUiState = "Set the Mars API status response here!"
        /*viewModelScope.launch {
            val listResult = MarsApi.retrofitService.getPhotos()
            marsUiState = listResult
        }*/

        /*viewModelScope.launch {
            marsUiState = try {
                val listResult = MarsApi.retrofitService.getPhotos()
                MarsUiState.Success(listResult.toString())
            } catch (e: IOException) {
                MarsUiState.Error
//                val msg = "${e.message}: IOException ${MarsUiState.Error}"
            }
        }*/
        viewModelScope.launch {

            val listResult = MarsApi.retrofitService.getPhotos()
            marsUiState = MarsUiState.Success(
                "Success: ${listResult.size} Mars photos retrieved"
            )
        }
    }


}

