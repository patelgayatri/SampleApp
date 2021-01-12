package com.techand.sampletest.data.models

import java.io.Serializable

data class Album(
    var albumId:Int,
    var id: Int,
    var title: String,
    var url: String,
    var thumbnailUrl: String,
):Serializable{
    fun getPhotoId(): String {
        return "Photo ID: $id"
    }
    fun getAlbumID(): String {
        return "Album ID: $albumId"
    }
}