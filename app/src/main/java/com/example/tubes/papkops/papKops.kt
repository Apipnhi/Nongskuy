package com.example.tubes.papkops

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tubes.Route
import com.example.tubes.asset
import com.example.tubes.data.MapVenueMarker

@Composable
fun papKops(navController: NavController){
    var selected by remember { mutableStateOf<MapVenueMarker>(MapVenueMarker("","",0.0,0.0)) }
    val marker = listOf<MapVenueMarker>(
        MapVenueMarker("1", "ARAH COFFE",-7.760537,110.380928),
        MapVenueMarker("2", "Living Option",-7.7688587,110.418410),
    )

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(asset.bg)
            .padding(WindowInsets.statusBars.asPaddingValues())
            .padding(WindowInsets.navigationBars.asPaddingValues())

    ){
        Spacer(Modifier.padding(10.dp))
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 10.dp)
        ){
            Button(onClick = {navController.navigate(Route.sore)},
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
                    imageVector = Icons.Default.ChevronLeft,
                    contentDescription = "",
                    modifier = Modifier
                        .size(35.dp)
                )
            }

            Text(text = "New Nong's",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,

                )
        }
        Column (Modifier.fillMaxSize().padding(top = 10.dp, start = 30.dp, end = 30.dp)){
            Spacer(Modifier.padding(10.dp))

            Text(text = "Pilih Lokasi Anda",
                fontSize = 15.sp,
                )
            FlowRow {
                marker.forEach { category ->
                    Button(
                        onClick = { selected = category },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (selected == category)
                                asset.mainColor else asset.rGelap,
                            contentColor = if (selected == category)
                                asset.bGelap else Color.White
                        )
                    ) {
                        Text(category.name)
                    }
                    Spacer(Modifier.padding(5.dp))
                }
            }




        }


    }

}