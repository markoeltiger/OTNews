package com.mark.orangetask.domain.model

data class NewsListings(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)