package com.example.tubes.profile


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons

import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.KeyboardArrowLeft

import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Refresh
import androidx.compose.material.icons.outlined.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tubes.AppImage
import com.example.tubes.Route
import com.example.tubes.asset
import com.example.tubes.R


@Composable
fun settingsActivity( navController: NavController){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(asset.bg)
            .padding(WindowInsets.statusBars.asPaddingValues()

            )
    ){
        Spacer(Modifier.padding(10.dp))
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        ){
            Button(onClick = {navController.navigate(Route.mainProfile)},
                colors = ButtonColors(
                    containerColor = asset.bg,
                    contentColor = asset.rGelap,
                    disabledContentColor = asset.rGelap,
                    disabledContainerColor = asset.bg
                ),
                contentPadding = PaddingValues(0.dp),
                modifier = Modifier
                    .align(Alignment.CenterStart)

            ) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = "",
                    modifier = Modifier
                        .size(35.dp)
                )
            }

            Text(text = "Settings Activity",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,

                )
        }

        Column (Modifier.fillMaxWidth().padding(horizontal = 30.dp, vertical = 20.dp)){
            Button(onClick = {},
                colors = ButtonColors(
                    containerColor = asset.bg,
                    contentColor = asset.bGelap,
                    disabledContentColor = asset.rGelap,
                    disabledContainerColor = asset.bg
                ),
                contentPadding = PaddingValues(0.dp),

                ) {
                Row (verticalAlignment = Alignment.CenterVertically){
                    Icon(
                        imageVector = Icons.Outlined.Favorite,
                        contentDescription = null,
                        Modifier.size(30.dp)
                    )
                    Spacer(Modifier.padding(5.dp))
                    Text(text = "Like", fontSize = 20.sp, )
                }
            }

            Button(onClick = {},
                colors = ButtonColors(
                    containerColor = asset.bg,
                    contentColor = asset.bGelap,
                    disabledContentColor = asset.rGelap,
                    disabledContainerColor = asset.bg
                ),
                contentPadding = PaddingValues(0.dp),

                ) {
                Row (verticalAlignment = Alignment.CenterVertically){
                    Icon(
                        imageVector = Icons.Outlined.Refresh,
                        contentDescription = null,
                        Modifier.size(30.dp)
                    )
                    Spacer(Modifier.padding(5.dp))
                    Text(text = "Archive", fontSize = 20.sp, )
                }
            }

            Button(onClick = {},
                colors = ButtonColors(
                    containerColor = asset.bg,
                    contentColor = asset.bGelap,
                    disabledContentColor = asset.rGelap,
                    disabledContainerColor = asset.bg
                ),
                contentPadding = PaddingValues(0.dp),

                ) {
                Row (verticalAlignment = Alignment.CenterVertically){
                    Icon(
                        imageVector = Icons.Outlined.Lock,
                        contentDescription = null,
                        Modifier.size(30.dp)
                    )
                    Spacer(Modifier.padding(5.dp))
                    Text(text = "Account privacy", fontSize = 20.sp, )
                }
            }

            Button(onClick = {},
                colors = ButtonColors(
                    containerColor = asset.bg,
                    contentColor = asset.bGelap,
                    disabledContentColor = asset.rGelap,
                    disabledContainerColor = asset.bg
                ),
                contentPadding = PaddingValues(0.dp),

                ) {
                Row (verticalAlignment = Alignment.CenterVertically){
                    Icon(
                        imageVector = Icons.Outlined.Warning,
                        contentDescription = null,
                        Modifier.size(30.dp)
                    )
                    Spacer(Modifier.padding(5.dp))
                    Text(text = "Blocked", fontSize = 20.sp, )
                }
            }


            Button(onClick = {},
                colors = ButtonColors(
                    containerColor = asset.bg,
                    contentColor = Color(0xFFFF0000),
                    disabledContentColor = Color(0xFFFF0000),
                    disabledContainerColor = asset.bg
                ),
                contentPadding = PaddingValues(0.dp),

                ) {
                    Text(text = "Log Out", fontSize = 20.sp, )

            }


        }


    }

}