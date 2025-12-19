package com.example.tubes.gangMatch

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tubes.R
import com.example.tubes.Route
import com.example.tubes.asset
import com.example.tubes.navigation.barAtasGangMatch
import com.example.tubes.data.broadcast
import com.example.tubes.navigation.mainNav

@Composable
fun gangMatch(navController: NavController){
    val navControllerGangMatch = rememberNavController()
    var jumlahOrang: Int = 0
    var namaTempat: String = "Nama_Tempat"
    val broadcast = listOf<broadcast>(
        broadcast("Gaming", R.drawable.defaultprofile, "Alexander", "Kurang 2 mobile Legend", 3),
        broadcast("Study", R.drawable.defaultprofile, "Brain", "Anak IT ayo kumpul", 5),
        broadcast("Card game", R.drawable.defaultprofile, "Bima", "Kurang 1 pemain nih", 3),
        broadcast(
            "Ngobrol",
            R.drawable.defaultprofile,
            "Ayub",
            "Asik sih kayaknya bahas  sejarah",
            20
        ),
        broadcast("Music", R.drawable.defaultprofile, "Darren", "Jamming santai malam ini", 4),
        broadcast("Movie Night", R.drawable.defaultprofile, "Luna", "Ayo nobar film thriller!", 6),
        broadcast(
            "Coding",
            R.drawable.defaultprofile,
            "Sinta",
            "Ngoding bareng, bawa laptop ya",
            2
        ),
    )



    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(asset.bg),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween

    ){
        barAtasGangMatch(navController, jumlahOrang, namaTempat)
        Row (
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .fillMaxWidth()

        ){
            Button(onClick = { navControllerGangMatch.navigate(Route.forYou)},
                colors = ButtonColors(
                    containerColor = asset.bg,
                    contentColor = asset.bGelap,
                    disabledContentColor = asset.bg,
                    disabledContainerColor = asset.bGelap
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                ) {
                Text("For You",
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    )

            }
            Button(onClick = { navControllerGangMatch.navigate(Route.me)},
                colors = ButtonColors(
                    containerColor = asset.bg,
                    contentColor = asset.bGelap,
                    disabledContentColor = asset.bg,
                    disabledContainerColor = asset.bGelap
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                ) {
                Text("Me",
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                )

            }
        }


        Box(Modifier.fillMaxWidth().weight(1f)){
            NavHost(
                navController = navControllerGangMatch, startDestination = Route.forYou, builder = {
                    composable(Route.forYou) {
                        forYou(broadcast)

                    }
                    composable(Route.me) {
                        me(navController)

                    }

                })

            OutlinedButton (onClick = {
                navController.navigate(Route.invite)
            },
                shape = RoundedCornerShape(10.dp),
                colors = ButtonColors(
                    containerColor = asset.bGelap,
                    contentColor = asset.mainColor,
                    disabledContentColor = asset.mainColor,
                    disabledContainerColor = asset.bGelap
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .padding(horizontal = 20.dp)

            ) {
                Text("Nong's Skuyyy!!!")
            }

        }





            mainNav(navController)


    }
}