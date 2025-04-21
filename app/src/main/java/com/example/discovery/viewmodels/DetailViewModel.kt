package com.example.discovery.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.discovery.models.TweetListItem
import com.example.discovery.repository.TweetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val repository: TweetRepository) : ViewModel() {

    val tweets: StateFlow<List<TweetListItem>>
        get() = repository.tweets


    init {
        viewModelScope.launch {
            repository.getTweets("ios")
        }
    }
}