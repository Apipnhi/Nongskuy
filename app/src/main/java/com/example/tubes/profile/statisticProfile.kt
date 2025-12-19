package com.example.tubes.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tubes.asset

@Composable
fun statisticProfile(navController: NavController, checkIn: Int, uniqueVenues: Int, friendsMet: Int, avgH: Int, avgM: Int ){


    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 25.dp,
                vertical = 30.dp
            )
    ){
        Text(
            text = "Your Social Journey",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            )
        Text(
            text = "Track your venue visits and sosial connections",
            color = asset.mainColor,
            fontSize = 12.sp,
            modifier = Modifier
                .padding(
                    vertical = 5.dp
                )
        )

        Spacer(
            Modifier.padding(
                vertical = 15.dp
            )
        )

        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()

        ){
            Row (
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
            ){
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(5.dp))
                        .background(asset.rMainColor)


                ){


                    Column (
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier

                            .padding(
                                horizontal = 15.dp,
                                vertical = 15.dp

                            )
                    ){
                        Text(
                            text = "Total Check-ins",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = checkIn.toString(),

                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .padding(
                                    horizontal = 15.dp,
                                    vertical = 15.dp
                                )

                        )

                        Text(
                            text = "Across all venues",
                            fontSize = 15.sp,
                            color = asset.rGelap
                        )
                    }

                }

                Spacer(
                    Modifier.padding(
                        horizontal = 15.dp
                    )
                )

                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(5.dp))
                        .background(asset.rMainColor)


                ){
                    Column (
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier

                            .padding(
                                horizontal = 15.dp,
                                vertical = 15.dp

                            )
                    ){
                        Text(
                            text = "Unique venues",
                            fontWeight = FontWeight.Bold,
                            fontSize = 15.sp,
                        )
                        Text(
                            text = uniqueVenues.toString(),
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .padding(
                                    horizontal = 15.dp,
                                    vertical = 15.dp
                                )

                        )

                        Text(
                            text = "Places visited",
                            fontSize = 15.sp,
                            color = asset.rGelap
                        )
                    }
                }



            }

            Spacer(
                Modifier.padding(
                    vertical = 15.dp
                )
            )

            Row {
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(5.dp))
                        .background(asset.rMainColor)


                ){


                    Column (
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier

                            .padding(
                                horizontal = 15.dp,
                                vertical = 15.dp

                            )
                    ){
                        Text(
                            text = "Friends Met",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = friendsMet.toString(),
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .padding(
                                    horizontal = 15.dp,
                                    vertical = 15.dp
                                )

                        )

                        Text(
                            text = "Across all venues",
                            fontSize = 15.sp,
                            color = asset.rGelap
                        )
                    }

                }

                Spacer(
                    Modifier.padding(
                        horizontal = 15.dp
                    )
                )

                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(5.dp))
                        .background(asset.rMainColor)


                ){
                    Column (
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier

                            .padding(
                                horizontal = 15.dp,
                                vertical = 15.dp

                            )
                    ){
                        Text(
                            text = "Avg Duration",
                            fontWeight = FontWeight.Bold,
                            fontSize = 15.sp,
                        )
                        Text(
                            text = "${avgH.toString()}h ${avgM.toString()}m",
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .padding(
                                    horizontal = 15.dp,
                                    vertical = 15.dp
                                )

                        )

                        Text(
                            text = "Places visited",
                            fontSize = 15.sp,
                            color = asset.rGelap
                        )
                    }
                }

            }
        }


    }
}