package com.nowni.marsphotos.fake

import com.nowni.marsphotos.model.MarsPhoto
import com.nowni.marsphotos.network.MarsApiService

class FakeMarsApiService : MarsApiService {
    override suspend fun getPhotos(): List<MarsPhoto> {
        return FakeDataSource.photosList
    }

}