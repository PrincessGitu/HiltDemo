package com.example.hiltdemo.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.hiltdemo.models.Result

@Database(entities = [Result::class], version = 1)
abstract class QuoteDatabase :RoomDatabase(){

    abstract fun getDao() : QuoteDAO

}