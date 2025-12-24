package com.example.tubes.gangMatch

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tubes.AppImage
import com.example.tubes.AppImageKotak
import com.example.tubes.Route
import com.example.tubes.asset
import com.example.tubes.R
import com.example.tubes.data.broadcast

@Composable
fun me(navController: NavController ){
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val uGambar = screenWidth-20.dp


    Column {
        Row (
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .fillMaxWidth()
        ){
            Divider(
                thickness = 2.dp,
                color = asset.bg,
                modifier = Modifier
                    .width(screenWidth/4)
            )

            Divider(
                thickness = 2.dp,
                color = asset.mainColor,
                modifier = Modifier
                    .width(screenWidth/4)
            )
        }

        Spacer(Modifier.padding(5.dp))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .weight(1f)
                .padding(horizontal = 10.dp),
        ) {
            AppImageKotak(String(),R.drawable.cafe1,
                Modifier
                    .size(uGambar)
                    .aspectRatio(1f)
                    .padding(1.dp))

            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = 15.dp,
                    )
                    .border(1.dp, color = asset.mainColor,RoundedCornerShape(15.dp))
            ){
                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                ){
                    Text(text = "GAME",
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

                    Text(text = "-2 Pubg di lantai 1",
                        color = asset.rGelap,)



                }



            }






        }






    }

}