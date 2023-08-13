package com.mark.orangetask.data.remote

import com.mark.orangetask.domain.model.NewsListings
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query


interface NewsApi {


    @GET("v2/everything?domains=wsj.com&apiKey=062df85540494afc844d5a9611e81526")
    suspend fun getNewsListings(
    ): NewsListings




    companion object {
        const val API_KEY = "062df85540494afc844d5a9611e81526"
        const val BASE_URL = "https://newsapi.org/"
    }
}