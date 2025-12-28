package com.example.tubes.data.user

import kotlinx.serialization.Serializable

@Serializable
class UserRegister (
    val username: String,
    val email: String,
    val password: String,
)