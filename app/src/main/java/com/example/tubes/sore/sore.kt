package com.example.tubes.sore

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.tubes.asset
import com.example.tubes.navigation.barAtasSore
import com.example.tubes.navigation.mainNav
import com.example.tubes.maps.maps

@Composable
fun sore(navController: NavController,  userId: String, username: String){
    val context = LocalContext.current


    Column (
        Modifier
            .fillMaxSize()
            .background(asset.bg),

        horizontalAlignment = Alignment.CenterHorizontally,


    ){
        barAtasSore()
        Box (
            Modifier
                .fillMaxSize()
                .background(asset.bg)
                .weight(1f),
        ){
            maps(context, userId, username)
        }

        Column {

            mainNav(navController, userId, username)
        }



    }

}