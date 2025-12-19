package com.example.tubes.data

data class MapVenueMarker(
    val venueId: String,
    val name: String,
    val latitude: Double,
    val longitude: Double,
    val onlineCount: Int? = null
)