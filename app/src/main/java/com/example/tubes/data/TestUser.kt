package com.example.tubes.data

import kotlinx.serialization.Serializable

@Serializable
data class TestUser(
    val id: Long? = null,
    val name: String,
    val created_at: String? = null
)