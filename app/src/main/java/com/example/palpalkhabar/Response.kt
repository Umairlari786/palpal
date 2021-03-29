package com.example.palpalkhabar

data class Response (
    val articles:List<News>,
    val status: String,
    val totalResults: Int
        )