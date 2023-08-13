package com.mark.orangetask.ui.news_listings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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

    init {
    }
    private fun getNewsListings(){
        viewModelScope.launch (Dispatchers.IO){
            repository.getNewsListings().collect{result->
                when(result){
                    is Resource.Success->{

                    }


                    else -> {}
                }

            }
        }
    }
}