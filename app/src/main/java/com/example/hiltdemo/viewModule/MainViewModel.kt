package com.example.hiltdemo.viewModule

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hiltdemo.models.QuoteList
import com.example.hiltdemo.repository.QuoteRepository
import com.example.hiltdemo.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor  (private val repository: QuoteRepository) :ViewModel(){

    init {
        viewModelScope.launch  (Dispatchers.IO){
            repository.getQuotes(1)
        }
    }
    val quotes:LiveData<Resource<QuoteList>>
    get() = repository.quoteList

}