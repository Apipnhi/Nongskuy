package com.example.tubes.maps

import com.example.tubes.data.SupabaseClient
import com.example.tubes.data.visitvenue.VisitWithVenue
import com.google.android.gms.maps.model.LatLng
import io.github.jan.supabase.postgrest.from
import io.github.jan.supabase.postgrest.query.Columns

suspend fun getVisitLocations(userId: String): List<LatLng> {
    val result = SupabaseClient.client
        .from("visits")
        .select(
            Columns.raw("venues(latitude, longitude)")
        ) {
            filter {
                eq("user_id", userId)
            }
        }
        .decodeList<VisitWithVenue>()

    return result.map {
        LatLng(
            it.venues.latitude,
            it.venues.longitude
        )
    }
}
