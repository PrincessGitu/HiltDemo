package com.example.hiltdemo.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.hiltdemo.api.RetrofitAPI

import com.example.hiltdemo.models.QuoteList
import com.example.hiltdemo.utils.NetworkUtils
import com.example.hiltdemo.utils.Resource
import com.example.hiltdemo.db.QuoteDatabase
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val quoteService: RetrofitAPI,
    private val database: QuoteDatabase,
    private val networkUtils:NetworkUtils
) {

    private val quoteListLiveData = MutableLiveData<Resource<QuoteList>>()

    val quoteList: LiveData<Resource<QuoteList>>
        get() = quoteListLiveData


    suspend fun getQuotes(page: Int) {

        if (networkUtils.isInternetAvailable()) {
            try {
                val result = quoteService.getQuote(page)
                if (result.body() != null) {
                    database.getDao().insertQuote(result.body()!!.results)
                    quoteListLiveData.postValue(Resource.Success(result.body()))
                }else{
                    quoteListLiveData.postValue(Resource.Error("API Error"))
                }
            }catch (ex:Exception){
                quoteListLiveData.postValue(Resource.Error(ex.message.toString()))
            }

        } else {
            val quotes = database.getDao().getQuotes()
           // val quotes = database.getDao().getQuotesByAuthor()
           // val quotes = database.getDao().getQuotesByAuthors("Thomas Edison")
            val quotesList = QuoteList(1, 1, 1, quotes, 1, 1)
            quoteListLiveData.postValue(Resource.Success(quotesList))
        }


    }
}