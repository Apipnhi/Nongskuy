package com.example.tubes.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.tubes.R

@Composable
fun feedProfile(){

    val feeds = listOf<Int>(
        R.drawable.cafe1,
        R.drawable.cafe2,
        R.drawable.cafe3,
        R.drawable.cafe4,
        R.drawable.cafe5,
        R.drawable.cafe6,
        R.drawable.cafe7,
        R.drawable.cafe8,

    )

    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val paddingFeed = 1.dp
    val feedSize = (screenWidth - paddingFeed*2 ) / 3

    FlowRow(
        maxItemsInEachRow = 5,
        modifier = Modifier
            .padding(1.dp)
    ) {
        feeds.reversed().forEach { feed ->
            Image(
                painter = painterResource(feed),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(feedSize )
                    .aspectRatio(1f)
                    .padding(1.dp)

            )
        }


    }
}