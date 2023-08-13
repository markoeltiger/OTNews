package com.mark.orangetask.domain.repository

import com.mark.orangetask.domain.model.NewsListings
import com.mark.orangetask.utils.Resource
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    fun getNewsListings(

    ): Flow<Resource<NewsListings>>

}