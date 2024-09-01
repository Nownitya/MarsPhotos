package com.nowni.marsphotos.model

import kotlinx.serialization.SerialName

data class MarsPhoto(
    val id: String,
    @SerialName(value = "img_src")
    val imgScr:String
)
