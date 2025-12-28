package com.example.tubes.loginRegister

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tubes.maps.RequestLocationPermission

import com.example.tubes.Route
import com.example.tubes.asset
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun login(navController: NavController){

    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val localContext = LocalContext.current


    RequestLocationPermission()


    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(asset.bg)
            .padding(50.dp)
    ){

        OutlinedTextField(value = username.value, onValueChange = {username.value = it}, Modifier.fillMaxWidth(), label = { Text("Username") })
        Spacer(modifier = Modifier.padding(10.dp))
        OutlinedTextField(value = password.value, onValueChange = {password.value = it}, Modifier.fillMaxWidth(), label = { Text("Password") })
        Spacer(modifier = Modifier.padding(10.dp))

        Button(onClick = {
            CoroutineScope(Dispatchers.Main).launch {

                val user = loginUser(username.value, password.value)

                if (user != null) {
                    navController.navigate(
                        "screen_Sore/${user.id}/${user.username}"
                    )
                } else {
                    Toast.makeText(
                        localContext,
                        "Username atau password salah",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        },
            colors = ButtonColors(
                containerColor = asset.bGelap,
                contentColor = asset.bg,
                disabledContentColor = asset.bg,
                disabledContainerColor = asset.bGelap
            ),
        modifier = Modifier
            .fillMaxWidth()


        ) {
            Text(text = "Login")
        }

        Button(onClick = {
            navController.navigate(Route.register)},
            colors = ButtonColors(
                containerColor = asset.bg,
                contentColor = asset.mainColor,
                disabledContentColor = asset.mainColor,
                disabledContainerColor = asset.bg
            ),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text("+ Create new acount")
        }






    }



}

