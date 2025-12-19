package com.example.tubes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tubes.gangMatch.gangMatch
import com.example.tubes.gangMatch.invite
import com.example.tubes.profile.editProfile
import com.example.tubes.profile.profile
import com.example.tubes.profile.settingsActivity
import com.example.tubes.sore.sore
import com.example.tubes.loginRegister.login
import com.example.tubes.loginRegister.register

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            mainStart()

        }
    }
}

