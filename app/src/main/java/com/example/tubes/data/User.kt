package com.example.tubes.data

data class User(
    val id: String,
    val email: String,
    val username: String,
    val password: String,
    val avatarUrl: String? = null,
    val lastKnownVenueId: String? = null,
    val bio: String? = null,
    val totalVisits: Int? = 0,
)
