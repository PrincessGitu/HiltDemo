package com.example.hiltdemo.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import com.example.hiltdemo.models.Result

@Dao
interface QuoteDAO {

   @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuote(quote: List<Result>)

    @Query("select * from quotes")
    suspend fun getQuotes() : List<Result>

    @Query("select * from quotes where author='Charles Dickens'")
    suspend fun getQuotesByAuthor():List<Result>

    @Query("select * from quotes where author like :author")
    suspend fun getQuotesByAuthors(author:String):List<Result>

    /*@Query("select * from quotes where author = :author")
    suspend fun getQuotesByAuthors(author:String):List<Result>*/
}

