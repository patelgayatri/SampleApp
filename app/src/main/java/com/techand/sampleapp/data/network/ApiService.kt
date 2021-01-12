package com.techand.sampleapp.data.network

import com.techand.sampleapp.data.models.User
import retrofit2.Response
import retrofit2.http.GET

const val BASE_URL = "https://jsonplaceholder.typicode.com/"


interface ApiService {

    @GET("/users")
    suspend fun getUserData(): Response<List<User>>

}

