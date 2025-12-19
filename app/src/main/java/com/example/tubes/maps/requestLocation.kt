package com.example.tubes.maps

import android.Manifest
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext

@Composable
fun RequestLocationPermission() {
    val context = LocalContext.current

    val launcher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            // izin diberikan
        } else {
            // izin ditolak
        }
    }

    LaunchedEffect(Unit) {
        launcher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
    }
}