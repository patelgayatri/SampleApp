package com.techand.sampleapp.data.network

import com.techand.sampleapp.data.models.User
import com.techand.sampletest.data.models.Album
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL = "https://jsonplaceholder.typicode.com/"


interface ApiService {

    @GET("/users")
    suspend fun getUserData(): Response<List<User>>

    @GET("/photos")
    suspend fun getPhotos(@Query("albumId") albumId: String): Response<List<Album>>
}

