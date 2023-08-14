package com.mark.orangetask.ui.news_listings

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mark.orangetask.domain.model.NewsListings
import com.mark.orangetask.domain.repository.NewsRepository
import com.mark.orangetask.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsListingsViewModel @Inject constructor(
    private val repository: NewsRepository
    ):ViewModel(){
    var state by mutableStateOf(NewListingsState())

    init {
        getNewsListings()
    }
    private fun getNewsListings(){
        viewModelScope.launch (Dispatchers.IO){
            repository.getNewsListings().collect{result->
                when(result){
                    is Resource.Success->{
                       state= state.copy(news = result.data!!.articles)

                    }
                    else -> {}
                }

            }
        }
    }
}