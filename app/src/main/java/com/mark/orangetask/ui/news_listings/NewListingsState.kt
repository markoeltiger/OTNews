package com.mark.orangetask.ui.news_listings

import com.mark.orangetask.domain.model.Article
import com.mark.orangetask.domain.model.NewsListings

data class NewListingsState(val news:List<Article> = emptyList(),
                            val isLoading: Boolean = false,
                            val isRefreshing: Boolean = false,)
