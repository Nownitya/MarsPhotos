package com.nowni.marsphotos.fake

import com.nowni.marsphotos.data.MarsPhotosRepository
import com.nowni.marsphotos.model.MarsPhoto

class FakeNetworkMarsPhotosRepository : MarsPhotosRepository {
    override suspend fun getMarsPhotos(): List<MarsPhoto> {
        return FakeDataSource.photosList
    }

}