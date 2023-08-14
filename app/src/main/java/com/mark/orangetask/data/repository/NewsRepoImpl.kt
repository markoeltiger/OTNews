package com.mark.orangetask.data.repository

import android.util.Log
import com.mark.orangetask.data.remote.NewsApi
import com.mark.orangetask.domain.model.NewsListings
import com.mark.orangetask.domain.repository.NewsRepository
import com.mark.orangetask.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NewsRepoImpl @Inject constructor(
    private val newsApi: NewsApi

) : NewsRepository {



    override fun getNewsListings(): Flow<Resource<NewsListings>> {
        return flow<Resource<NewsListings>> {

            emit(Resource.Loading(true))

            try {
                val response = newsApi.getNewsListings()
                emit(Resource.Success(response))

            } catch (e: IOException) {
                e.printStackTrace()
                emit(Resource.Error("Couldn't load data"))
                null
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Resource.Error("Couldn't load data"))
                null
            }
            emit(Resource.Loading(false))



        }    }
}