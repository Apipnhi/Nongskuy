package com.example.tubes.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
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
import com.example.tubes.navigation.barAtasProfile
import com.example.tubes.navigation.mainNav
import com.example.tubes.maps.maps
import com.example.tubes.navigation.profileNav


@Composable
fun profile(navControllerMain: NavController,  userId: String, username: String){
    var post: Int = 0
    var places: Int = 0
    var friends: Int = 0
    var namaPengguna = "Nama_Pengguna"
    var bio = "Apa saja yang penting deskripsi. Buat ga lebih dari 2 baris "

    // data untuk tampilan statistic
    var checkIn: Int  = 0
    var uniqueVenues: Int = 0
    var friendsMet: Int = 0
    var avgH: Int = 0
    var avgM: Int = 0

    val context = LocalContext.current


    val navControllerProfile = rememberNavController()

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(asset.bg)
            ,
        horizontalAlignment = Alignment.CenterHorizontally,


        ){


        Column (
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
                .verticalScroll(rememberScrollState())


        ){

                barAtasProfile(navControllerMain)


                Column(
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)


                ) {
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                start = 25.dp,
                                end = 50.dp,
                                bottom = 10.dp
                            ),
                        horizontalArrangement = Arrangement.Center

                    ){
                        Image(
                            painter = painterResource(R.drawable.defaultprofile),
                            contentDescription = null,
                            modifier = Modifier
                                .size(100.dp)
                                .clip(CircleShape)

                        )
                        Column (
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.Start,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp)
                                .align(Alignment.CenterVertically)
                                .padding(
                                    start = 20.dp
                                )

                        ){
                            Text(
                                text = namaPengguna,
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp,
                                modifier = Modifier
                                    .padding(bottom = 5.dp)

                            )

                            Row (

                                horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier
                                    .fillMaxWidth()

                            ){
                                Column {
                                    Text(
                                        text = post.toString(),
                                        fontSize = 15.sp,
                                        fontWeight = FontWeight.Bold,

                                        )
                                    Text(text = "post",
                                        Modifier.padding(top = 5.dp),
                                        fontSize = 12.sp)
                                }
                                Column {
                                    Text(
                                        text = places.toString(),
                                        fontSize = 15.sp,
                                        fontWeight = FontWeight.Bold,

                                        )
                                    Text(text = "places",
                                        Modifier.padding(top = 5.dp),
                                        fontSize = 12.sp)
                                }
                                Column {
                                    Text(
                                        text = friends.toString(),
                                        fontSize = 15.sp,
                                        fontWeight = FontWeight.Bold,

                                        )
                                    Text(text = "friends",
                                        Modifier.padding(top = 5.dp),
                                        fontSize = 12.sp
                                    )


                                }
                            }
                        }
                    }

                    Text(
                        text = bio,
                        Modifier
                            .align(Alignment.Start)
                            .padding(
                                horizontal = 25.dp,
                                vertical = 10.dp
                            ),
                        fontSize = 12.sp

                    )

                    Row (

                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(

                                horizontal = 20.dp
                            )
                    ){
                        Button(
                            onClick = {navControllerMain.navigate(Route.editProfile)},
                            shape = RoundedCornerShape(5.dp),
                            modifier = Modifier
                                .weight(1f)
                                .padding(
                                    end = 5.dp,
                                )
                            ,

                            colors = ButtonColors(
                                containerColor = asset.bGelap,
                                contentColor = asset.bTerang,
                                disabledContentColor = asset.bTerang,
                                disabledContainerColor = asset.bGelap
                            )
                        ) {
                            Text(
                                text = "Edit Profile",
                            )
                        }
                        Button(
                            onClick = {},
                            shape = RoundedCornerShape(5.dp),
                            modifier = Modifier
                                .weight(1f)
                                .padding(
                                    start = 5.dp
                                ),
                            colors = ButtonColors(
                                containerColor = asset.bGelap,
                                contentColor = asset.bTerang,
                                disabledContentColor = asset.bTerang,
                                disabledContainerColor = asset.bGelap
                            )
                        ) {
                            Text(text = "Share Profile")
                        }
                    }

                    profileNav(navControllerProfile, userId,username)

                        Box (
                            modifier = Modifier.fillMaxSize()){


                            NavHost(
                                navController = navControllerProfile,
                                startDestination = Route.feedProfile,
                                builder = {
                                    composable(Route.feedProfile) {
                                        feedProfile()

                                    }

                                    composable(Route.statisticProfile) {
                                        statisticProfile(
                                            navControllerProfile,
                                            checkIn,
                                            uniqueVenues,
                                            friendsMet,
                                            avgH,
                                            avgM
                                        )
                                    }
                                    composable(Route.journeyProfile) {

                                        maps(context, userId, username) //sfdsaf

                                    }

                                })

                        }

                }









        }



        Box (

        ){
            mainNav(navControllerMain, userId,username)
        }


    }

}

