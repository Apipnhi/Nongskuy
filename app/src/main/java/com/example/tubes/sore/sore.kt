package com.example.tubes.sore

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tubes.Route
import com.example.tubes.asset
import com.example.tubes.navigation.barAtasSore
import com.example.tubes.navigation.mainNav
import com.example.tubes.maps.maps

@Composable
fun sore(navController: NavController){
    val context = LocalContext.current


    Column (
        Modifier
            .fillMaxSize()
            .background(asset.bg),

        horizontalAlignment = Alignment.CenterHorizontally,


    ){
        barAtasSore(navController)
        Box (
            Modifier
                .fillMaxSize()
                .background(asset.bg)
                .weight(1f),
        ){
            maps(context)
            OutlinedButton (onClick = {
                navController.navigate(Route.papKops)
            },

                colors = ButtonColors(
                    containerColor = asset.bGelap,
                    contentColor = asset.mainColor,

                    disabledContentColor = asset.mainColor,
                    disabledContainerColor = asset.bGelap
                ),
                contentPadding = PaddingValues(0.dp),
                border = BorderStroke(
                    width = 2.dp,
                    color = asset.mainColor
                ),

                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(horizontal = 25.dp, vertical = 25.dp)
                    .clip(CircleShape)
                    .size(80.dp)

            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "",
                    Modifier.size(50.dp)
                )
            }


        }

        Column {

            mainNav(navController)
        }



    }

}