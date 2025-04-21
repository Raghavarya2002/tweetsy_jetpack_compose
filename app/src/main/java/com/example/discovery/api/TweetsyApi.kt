package com.example.discovery.api

import com.example.discovery.models.TweetListItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers


interface TweetsyApi {

    @GET("/v3/b/67f910f18a456b7966874454?meta=false")
    suspend fun getTweets(
        @Header("X-JSON-Path")
        category: String
    ): Response<List<TweetListItem>>


    @GET("/v3/b/67f910f18a456b7966874454?meta=false")
    @Headers("X-JSON-Path: tweets..category")
    suspend fun getCategories(): Response<List<String>>
}