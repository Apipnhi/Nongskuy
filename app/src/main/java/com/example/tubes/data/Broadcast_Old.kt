package com.example.tubes.data

data class Broadcast(
    val id: String,
    val userId: String,
    val venueId: String,
    val category: BroadcastCategory,
    val description: String,
    val photoUrl: String? = null,
    val locationDescription: String? = null,
    val createdAt: Long,
    val expiresAt: Long
)

enum class BroadcastCategory {
    GAME, LEARN, CHAT, WORK, MUSIC, MOVIE, OTHER
}


data class broadcast(
    val tipeActivity: String,
    val mainProfile: Int,
    val namaPengguna: String,
    val deskripsi: String,
    val totalPeople: Int,
)