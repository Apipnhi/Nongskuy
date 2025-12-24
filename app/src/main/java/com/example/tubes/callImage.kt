package com.example.tubes

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage

@Composable
fun AppImage(
    imageUrl: String?,
    @DrawableRes placeholder: Int,
    modifier: Modifier = Modifier
) {
    if (imageUrl.isNullOrEmpty()) {
        Image(
            painter = painterResource(placeholder),
            contentDescription = null,
            modifier = modifier
        )
    } else {
        AsyncImage(
            model = imageUrl,
            contentDescription = null,
            modifier = modifier
        )
    }
}

@Composable
fun AppImageKotak(
    imageUrl: String?,
    @DrawableRes placeholder: Int,
    modifier: Modifier = Modifier
) {
    if (imageUrl.isNullOrEmpty()) {
        Image(
            painter = painterResource(placeholder),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = modifier
        )
    } else {
        AsyncImage(
            model = imageUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = modifier
        )
    }
}