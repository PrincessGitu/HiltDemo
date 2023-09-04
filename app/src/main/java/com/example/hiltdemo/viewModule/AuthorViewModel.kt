package com.example.hiltdemo.viewModule

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hiltdemo.models.AuthorsList
import com.example.hiltdemo.repository.AuthorRepository
import com.example.hiltdemo.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthorViewModel @Inject constructor(private val authorRepository: AuthorRepository):ViewModel(){

    init {
        viewModelScope.launch (Dispatchers.IO){
            authorRepository.getAuthors()
        }
    }
    val authors: LiveData<Resource<AuthorsList>>
        get() = authorRepository.authorsList
}