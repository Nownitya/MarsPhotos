package com.nowni.marsphotos.fake

import com.nowni.marsphotos.data.NetworkMarsPhotosRepository
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class NetworkMarsRepositoryTest {
    @Test
    fun networkMarsPhotosRepository_getMarsPhotos_verifyPhotosRepository()= runTest {
        val repository = NetworkMarsPhotosRepository(
            marsApiService = FakeMarsApiService()
        )
        assertEquals(FakeDataSource.photosList,repository.getMarsPhotos())
    }

    /*@Test
    fun networkMarsPhotosRepository_getMarsPhotos() {

    }*/
}