package com.techand.sampleapp.data.repository

import com.techand.sampleapp.data.models.User
import com.techand.sampleapp.data.network.ApiService
import retrofit2.Response
import javax.inject.Inject


class UserInfoRepository @Inject constructor(
    private val remoteDataSource: ApiService
) {

    suspend fun getUser(): Response<List<User>> {
        return remoteDataSource.getUserData()
    }

}