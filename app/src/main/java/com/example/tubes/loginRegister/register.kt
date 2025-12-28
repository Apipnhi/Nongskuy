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
import com.example.tubes.Route
import com.example.tubes.asset
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Composable
fun register(navController: NavController){
    val localContext = LocalContext.current
//    untuk input text field
    val userName = remember { mutableStateOf("") }
    val  email= remember { mutableStateOf("") }
    val password= remember { mutableStateOf("") }
    val noTelp = remember { mutableStateOf("") }
    val gender = remember { mutableStateOf("") }


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(asset.bg)
            .padding(50.dp)
        ) {
        OutlinedTextField(value = userName.value, onValueChange = {userName.value = it},Modifier.fillMaxWidth(), label = { Text("Username") })
        OutlinedTextField(value = email.value, onValueChange = {email.value = it},Modifier.fillMaxWidth(), label = { Text("Email") })
        OutlinedTextField(value = password.value, onValueChange = {password.value = it},Modifier.fillMaxWidth(), label = { Text("Password") })
        OutlinedTextField(value = noTelp.value, onValueChange = {noTelp.value = it},Modifier.fillMaxWidth(), label = { Text("No Telp") })
        OutlinedTextField(value = gender.value, onValueChange = {gender.value = it}, Modifier.fillMaxWidth(), label = { Text("Gender") })

        Spacer(Modifier.padding(10.dp))

        Button(onClick = {


            if (
                userName.value.isNotEmpty() &&
                email.value.isNotEmpty() &&
                password.value.isNotEmpty()
            ) {

                CoroutineScope(Dispatchers.IO).launch {
                    try {
                        val success = registerUser(
                            username = userName.value,
                            email = email.value,
                            password = password.value
                        )

                        withContext(Dispatchers.Main) {
                            if (success) {
                                Toast.makeText(
                                    localContext,
                                    "Register berhasil",
                                    Toast.LENGTH_SHORT
                                ).show()
                                navController.navigate(Route.login)
                            } else {
                                Toast.makeText(
                                    localContext,
                                    "Username sudah digunakan",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }

                    } catch (e: Exception) {
                        withContext(Dispatchers.Main) {
                            Toast.makeText(
                                localContext,
                                "Terjadi kesalahan",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }

            } else {
                Toast.makeText(
                    localContext,
                    "Lengkapi data",
                    Toast.LENGTH_SHORT
                ).show()
            }
        },
            modifier = Modifier
                .fillMaxWidth()


        ) {
            Text("Create Account")

        }

    }





}