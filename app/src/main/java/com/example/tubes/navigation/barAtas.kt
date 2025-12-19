package com.example.tubes.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tubes.Route
import com.example.tubes.asset


@Composable
fun barAtasProfile(navController: NavController){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .background(asset.bg)
            .padding(WindowInsets.statusBars.asPaddingValues())
            .padding(
                top = 15.dp
            )

        ,
        verticalAlignment = Alignment.Bottom
    ){

        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            contentAlignment = Alignment.BottomCenter

        ){
            Text(
                text = "Profile",
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.Center),
                fontSize = 20.sp
            )
            Button(
                onClick = {navController.navigate(Route.settingsActivity)},
                colors = ButtonColors(
                    containerColor = asset.bg,
                    contentColor = asset.mainColor,
                    disabledContentColor = asset.mainColor,
                    disabledContainerColor = asset.bg
                ),
                modifier = Modifier
                    .align(Alignment.BottomEnd)

            ) {

                Icon(
                    imageVector = Icons.Outlined.Settings,
                    contentDescription = "",
                    tint = asset.mainColor,
                    modifier = Modifier
                        .size(30.dp)
                )
            }
        }
    }
}

@Composable
fun barAtasGangMatch(navController: NavController, jumlahOrang: Int, namaTempat: String){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .background(asset.bg)
            .drawBehind(){
                val strokeWidth = 2.dp.toPx()
                drawLine(
                    color = Color((asset.mainColor).toArgb()),
                    start = Offset(0f, size.height),
                    end = Offset(size.width, size.height),
                    strokeWidth = strokeWidth
                )
            },
        verticalAlignment = Alignment.CenterVertically,


    ){

        Column (
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .padding(WindowInsets.statusBars.asPaddingValues())
                .padding(
                    start = 25.dp
                    )
        ){
            Spacer(
                Modifier
                    .padding(20.dp)
            )
            Text(
                text = namaTempat,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp

                )
            Text(
                text = jumlahOrang.toString()+" people here",
                color = asset.mainColor
                )

            Spacer(
                Modifier
                    .padding(10.dp)
            )
        }
    }

}

@Composable
fun barAtasSore(navController: NavController){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .background(asset.bGelap)
            .drawBehind(){
                val strokeWidth = 3.dp.toPx()
                drawLine(
                    color = Color((asset.mainColor).toArgb()),
                    start = Offset(0f, size.height),
                    end = Offset(size.width, size.height),
                    strokeWidth = strokeWidth
                )
            },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,

    ){

        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,

            modifier = Modifier
                .padding(WindowInsets.statusBars.asPaddingValues())
                .padding(
                    bottom = 20.dp)
        ){
            Spacer(
                Modifier.padding(10.dp)
            )
            Text(
                text = "SORE",
                fontWeight = FontWeight.Bold,
                color = asset.bTerang,
                fontSize = 20.sp,
                modifier = Modifier

                )
        }


    }


}