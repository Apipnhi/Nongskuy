package com.example.tubes.profile


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
fun editProfile( navController: NavController,userName: String, avatarUrl: String?, bio: String){
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

            Text(text = "Edit Profile",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,

            )
        }

        Box(contentAlignment = Alignment.Center){
            AppImage(avatarUrl, R.drawable.defaultprofile, Modifier.size(100.dp).clip(CircleShape))
            Button(onClick = {},
                colors = ButtonColors(
                    containerColor = asset.bGelap,
                    contentColor = asset.mainColor,
                    disabledContentColor = asset.mainColor,
                    disabledContainerColor = asset.bGelap
                ),
                contentPadding = PaddingValues(0.dp),
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .clip(CircleShape)
                    .padding(end = 5.dp)
                    .size(25.dp)

                ) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = null,
                    modifier = Modifier
                        .size(15.dp)
                )
            }
        }

        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ){
            Text(text = "Username", fontWeight = FontWeight.Bold, fontSize = 17.sp)
            Text(text = userName,  fontSize = 15.sp, modifier = Modifier.padding(vertical = 10.dp))

            Divider(thickness = 1.dp, color = asset.rGelap)

            Text(text = "Bio", fontWeight = FontWeight.Bold, fontSize = 17.sp, modifier = Modifier.padding(top = 10.dp))
            Text(text = bio,  fontSize = 15.sp, modifier = Modifier.padding(vertical = 10.dp))

            Divider(thickness = 1.dp, color = asset.rGelap)

        }

    }

}