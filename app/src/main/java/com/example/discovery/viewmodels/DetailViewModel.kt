package com.example.discovery.viewmodels

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.discovery.models.TweetListItem
import com.example.discovery.repository.TweetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: TweetRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    val tweets: StateFlow<List<TweetListItem>>
        get() = repository.tweets


    init {
        viewModelScope.launch {
            val category = Regex("[a-zA-Z0-9_]+").find(savedStateHandle.get<String>("category") ?: "")?.value ?: "android"
            repository.getTweets(category)
        }
    }
}