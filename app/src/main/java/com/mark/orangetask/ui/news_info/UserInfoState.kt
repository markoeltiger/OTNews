package com.mark.orangetask.ui.news_info

import com.mark.orangetask.domain.model.Article
import com.mark.orangetask.domain.model.NewsListings

data class UserInfoState(val news:List<Article> = emptyList(),
                         val isLoading: Boolean = false,
                         val isRefreshing: Boolean = false)
