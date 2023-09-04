package com.example.hiltdemo.api

import com.example.hiltdemo.models.AuthorsList
import com.example.hiltdemo.models.QuoteList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitAPI {

    @GET("/quotes")
    suspend fun getQuote(@Query("page") page: Int): Response<QuoteList>

    @GET("/authors")
    suspend fun getAuthors(): Response<AuthorsList>

}
