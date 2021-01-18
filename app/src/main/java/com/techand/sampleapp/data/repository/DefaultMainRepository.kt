package com.techand.sampleapp.data.repository

import com.techand.sampleapp.data.models.User
import com.techand.sampleapp.data.network.ApiService
import com.techand.sampleapp.utils.Resource
import com.techand.sampletest.data.models.Album
import retrofit2.Response
import java.lang.Exception
import javax.inject.Inject

class DefaultMainRepository @Inject constructor(
    private val remoteDataSource: ApiService
) : MainRepository {

    override suspend fun getUser(): Response<List<User>> {
        return remoteDataSource.getUserData()
    }

    override suspend fun getPhotos(albumId: String): Response<List<Album>> {
        return remoteDataSource.getPhotos(albumId)
    }
}
