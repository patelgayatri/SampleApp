package com.techand.sampleapp.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.techand.sampleapp.data.repository.DefaultMainRepository
import com.techand.sampleapp.data.repository.MainRepository
import com.techand.sampleapp.utils.Resource
import kotlinx.coroutines.Dispatchers
import java.net.UnknownHostException

class ViewModel @ViewModelInject constructor(private val mainRepository: DefaultMainRepository) :
    ViewModel() {


    fun getUser() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = mainRepository.getUser()))
        } catch (exception: UnknownHostException) {
            emit(Resource.error(data = null, message = "No Internet Connection"))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }


    fun getPhotos(albumId: Int) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = mainRepository.getPhotos(albumId.toString())))
        } catch (exception: UnknownHostException) {
            emit(Resource.error(data = null, message = "No Internet Connection"))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}