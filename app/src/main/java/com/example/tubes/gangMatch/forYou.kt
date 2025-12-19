package com.example.tubes.gangMatch

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tubes.asset
import com.example.tubes.data.broadcast

@Composable
fun forYou(broadcast:List<broadcast>){
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp

    Column {
        Row (
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .fillMaxWidth()
        ){
            Divider(
                thickness = 2.dp,
                color = asset.mainColor,
                modifier = Modifier
                    .width(screenWidth/3)
            )

            Divider(
                thickness = 2.dp,
                color = asset.bg,
                modifier = Modifier
                    .width(screenWidth/3)
            )
        }



        LazyColumn (
            Modifier
                .fillMaxWidth()

        ){
            item {
                broadcast.forEach { broadcastList ->
                    Column (
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                start = 20.dp,
                                end = 20.dp,
                                top = 15.dp,
                            )
                            .border(1.dp, color = asset.mainColor,RoundedCornerShape(15.dp))
                    ){
                        Column (
                            modifier = Modifier
                                .padding(20.dp)
                        ){
                            Text(text = broadcastList.tipeActivity,
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp,
                                color = asset.mainColor,
                                modifier = Modifier
                                    .clip(RoundedCornerShape(20.dp))
                                    .background(asset.rMainColor)
                                    .padding(
                                        horizontal = 10.dp,
                                        vertical = 5.dp
                                    )


                            )
                            Spacer(Modifier.padding(5.dp))
                            Row (
                                verticalAlignment = Alignment.CenterVertically
                            ){
                                Image(
                                    painter = painterResource(broadcastList.mainProfile),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .padding(
                                            end = 10.dp
                                        )
                                        .size(40.dp)
                                        .clip(CircleShape)

                                )
                                Column (
                                    verticalArrangement = Arrangement.Center

                                ){
                                    Text(
                                        text = broadcastList.namaPengguna,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 15.sp,
                                    )
                                    Spacer(Modifier.padding(2.dp))
                                    Text(text = broadcastList.deskripsi,
                                        color = asset.rGelap,
                                    )
                                }
                            }
                            Spacer(Modifier.padding(5.dp))
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {

                                broadcast.take(3).forEach {items ->
                                    Image(
                                        painter = painterResource(items.mainProfile),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .padding(
                                                end = 2.dp
                                            )
                                            .size(20.dp)
                                            .clip(CircleShape)
                                        ,


                                        )
                                }
                                if (broadcast.size > 3){
                                    Text(text = "+${broadcast.size-3}",
                                        color = asset.mainColor
                                    )
                                }
                                Row (
                                    horizontalArrangement = Arrangement.End,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .weight(1f)
                                ){
                                    Divider(
                                        modifier = Modifier
                                            .height(25.dp)
                                            .width(2.dp),
                                        thickness = 2.dp,
                                        color = asset.mainColor)

                                    Spacer(Modifier.padding(5.dp))
                                    Button(onClick = {},
                                        colors = ButtonColors(
                                            containerColor = Color(0xFFFFD0D0),
                                            contentColor = Color(0xFFFF0000),
                                            disabledContentColor = Color(0xFFFFD0D0),
                                            disabledContainerColor = Color(0xFFFFD0D0)
                                        ),
                                        contentPadding = PaddingValues(0.dp),

                                        shape = RoundedCornerShape(10.dp),

                                        modifier = Modifier
                                            .size(30.dp)


                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Close,
                                            contentDescription = "",
                                            modifier = Modifier
                                                .size(25.dp)


                                        )
                                    }

                                    Spacer(Modifier.padding(5.dp))

                                    Button(onClick = {},
                                        colors = ButtonColors(
                                            containerColor = Color(0xFFCCFFD3),
                                            contentColor = Color(0xFF00FF22),
                                            disabledContentColor = Color(0xFFCCFFD3),
                                            disabledContainerColor = Color(0xFFCCFFD3)
                                        ),
                                        contentPadding = PaddingValues(0.dp),
                                        shape = RoundedCornerShape(10.dp),
                                        modifier = Modifier
                                            .size(30.dp)

                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Check,
                                            contentDescription = ""


                                        )
                                    }


                                }


                            }
                        }
                    }

                }
            }
            item { Spacer(Modifier.padding(30.dp)) }





        }

    }


}