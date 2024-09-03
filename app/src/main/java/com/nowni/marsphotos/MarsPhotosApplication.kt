package com.nowni.marsphotos

import android.app.Application
import com.nowni.marsphotos.data.AppContainer
import com.nowni.marsphotos.data.DefaultAppContainer

class MarsPhotosApplication : Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container=DefaultAppContainer()
    }

}