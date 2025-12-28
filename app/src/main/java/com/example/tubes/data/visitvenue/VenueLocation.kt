package com.example.tubes.data.visitvenue

import kotlinx.serialization.Serializable

@Serializable
data class VenueLocation(
    val latitude: Double,
    val longitude: Double
)