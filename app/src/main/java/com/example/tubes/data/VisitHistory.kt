package com.example.tubes.data

data class VisitHistory(
    val userId: String,
    val venueId: String,
    val date: String, // YYYY-MM-DD
    val visitCount: Int
)

