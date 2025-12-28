package com.example.tubes.data.user

import kotlinx.serialization.Serializable

@Serializable
class UserLogin(
    val id: String?,
    val username: String,
    val avatar_url: String?,
)
