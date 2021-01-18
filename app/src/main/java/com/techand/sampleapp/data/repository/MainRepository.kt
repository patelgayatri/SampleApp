package com.techand.sampleapp.data.repository

import com.techand.sampleapp.data.models.User
import com.techand.sampleapp.utils.Resource
import com.techand.sampletest.data.models.Album
import retrofit2.Response


interface MainRepository {

    suspend fun getUser(): Response<List<User>>

    suspend fun getPhotos(albumId: String): Response<List<Album>>

    }