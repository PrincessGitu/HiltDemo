package com.example.hiltdemo.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.hiltdemo.api.RetrofitAPI
import com.example.hiltdemo.models.AuthorsList
import com.example.hiltdemo.utils.NetworkUtils
import com.example.hiltdemo.utils.Resource
import javax.inject.Inject

class AuthorRepository @Inject constructor(private val retrofitAPI: RetrofitAPI,
    private val networkUtils: NetworkUtils) {

    private val authorListLiveData = MutableLiveData<Resource<AuthorsList>>()

    val authorsList: LiveData<Resource<AuthorsList>>
        get() = authorListLiveData

    suspend fun getAuthors() {

        if (networkUtils.isInternetAvailable()) {
            try {
                val result = retrofitAPI.getAuthors()
                if (result.body() != null) {
                    authorListLiveData.postValue(Resource.Success(result.body()))
                }else{
                    authorListLiveData.postValue(Resource.Error("API Error"))
                }
            }catch (ex:Exception){
                authorListLiveData.postValue(Resource.Error(ex.message.toString()))
            }

        } else {
            authorListLiveData.postValue(Resource.Error("No Internet Connectivity"))
        }


    }
}