package com.example.tubes.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddBox
import androidx.compose.material.icons.filled.Explore
import androidx.compose.material.icons.filled.GridView
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PieChart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tubes.Route
import com.example.tubes.asset


@Composable
fun mainNav(navController: NavController, userId: String, username: String){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .background(asset.mainColor)
            .padding(WindowInsets.navigationBars.asPaddingValues())
            .padding(horizontal = 10.dp)
        ,

        verticalAlignment = Alignment.Top
    ){
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center

        ){
            Button(
                onClick = {navController.navigate("gang_Match/$userId/$username")},
                colors = ButtonColors(
                    containerColor = asset.mainColor,
                    contentColor = asset.bTerang,
                    disabledContentColor = asset.bTerang,
                    disabledContainerColor = asset.mainColor
                )

                ) {

                Icon(
                    imageVector = Icons.Default.Explore,
                    contentDescription = "",
                    tint = asset.bTerang,
                    modifier = Modifier
                        .size(25.dp)



                )
            }

        }



        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),

            contentAlignment = Alignment.Center

        ){
            Button(
                onClick = {navController.navigate("screen_Sore/{userId}/{username}")},
                colors = ButtonColors(
                    containerColor = asset.mainColor,
                    contentColor = asset.bTerang,
                    disabledContentColor = asset.bTerang,
                    disabledContainerColor = asset.mainColor
                )
            ) {

                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "",
                    tint = asset.bTerang,
                    modifier = Modifier
                        .size(25.dp)
                )
            }

        }

        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),

            contentAlignment = Alignment.Center

        ){
            Button(
                onClick = {navController.navigate("screenSore/$userId/$username")},
                colors = ButtonColors(
                    containerColor = asset.mainColor,
                    contentColor = asset.bTerang,
                    disabledContentColor = asset.bTerang,
                    disabledContainerColor = asset.mainColor
                ),
                contentPadding = PaddingValues(0.dp)

            ) {

                Icon(
                    imageVector = Icons.Default.AddBox,
                    contentDescription = "",
                    tint = asset.bTerang,
                    modifier = Modifier
                        .size(25.dp)
                )
            }

        }



        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center

        ){
            Button(
                onClick = {navController.navigate("mainProfile/$userId/$username")},
                colors = ButtonColors(
                    containerColor = asset.mainColor,
                    contentColor = asset.bTerang,
                    disabledContentColor = asset.bTerang,
                    disabledContainerColor = asset.mainColor
                )
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "",
                    tint = asset.bTerang,
                    modifier = Modifier
                        .size(25.dp)


                )
            }

        }



    }
}

@Composable
fun profileNav(navController: NavController, userId: String, username: String){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .background(asset.mainColor),


        verticalAlignment = Alignment.Top
    ){

        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center

        ){
            Button(
                onClick = {navController.navigate("journey_profile/$userId/$username")},
                colors = ButtonColors(
                    containerColor = asset.mainColor,
                    contentColor = asset.bTerang,
                    disabledContentColor = asset.bTerang,
                    disabledContainerColor = asset.mainColor
                ),

            ) {

                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = "",
                    tint = asset.bTerang,
                    modifier = Modifier
                        .size(25.dp)



                )
            }

        }



        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),

            contentAlignment = Alignment.Center

        ){
            Button(
                onClick = {navController.navigate(Route.feedProfile)},
                colors = ButtonColors(
                    containerColor = asset.mainColor,
                    contentColor = asset.bTerang,
                    disabledContentColor = asset.bTerang,
                    disabledContainerColor = asset.mainColor
                )
            ) {

                Icon(
                    imageVector = Icons.Default.GridView,
                    contentDescription = "",
                    tint = asset.bTerang,
                    modifier = Modifier
                        .size(25.dp)
                )
            }

        }



        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center

        ){
            Button(
                onClick = {navController.navigate(Route.statisticProfile)},
                colors = ButtonColors(
                    containerColor = asset.mainColor,
                    contentColor = asset.bTerang,
                    disabledContentColor = asset.bTerang,
                    disabledContainerColor = asset.mainColor
                )
            ) {
                Icon(
                    imageVector = Icons.Default.PieChart,
                    contentDescription = "",
                    tint = asset.bTerang,
                    modifier = Modifier
                        .size(25.dp)


                )
            }

        }



    }
}


