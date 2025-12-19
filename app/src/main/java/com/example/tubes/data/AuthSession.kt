package com.example.tubes.data

data class AuthSession(
    val userId: String,
    val email: String,
    val token: String,
    val expiresAt: Long
)