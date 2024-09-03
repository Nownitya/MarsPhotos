package com.nowni.marsphotos.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.nowni.marsphotos.model.MarsPhoto
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET

interface MarsApiService {
    @GET("photos")
    suspend fun getPhotos():List<MarsPhoto>
}

