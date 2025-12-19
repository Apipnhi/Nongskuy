package com.example.tubes.maps

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState


@Composable
fun maps( context: Context){
    val cameraPositionState = rememberCameraPositionState()
    val mark = listOf<LatLng>(
        LatLng(-6.200000, 106.816666),
        LatLng(-6.200000, 106.916666),
    )


    val fusedLocationProviderClient = remember {
        LocationServices.getFusedLocationProviderClient(context)
    }

    LaunchedEffect (Unit) {
        if (ActivityCompat.checkSelfPermission(context,Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            fusedLocationProviderClient.lastLocation.addOnSuccessListener { location ->
                location?.let {
                    cameraPositionState.position = CameraPosition.fromLatLngZoom(
                        LatLng(it.latitude, it.longitude),
                        16f
                    )
                }
            }
        }
    }




    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState,
        properties = MapProperties(
            mapType = MapType.NORMAL,
            isMyLocationEnabled = true,
        ),
    ){
        mark.forEach {
            Marker(state = MarkerState(it))
        }
    }

}