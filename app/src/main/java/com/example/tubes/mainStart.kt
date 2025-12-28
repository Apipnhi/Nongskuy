package com.example.tubes

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.tubes.gangMatch.gangMatch
import com.example.tubes.gangMatch.invite
import com.example.tubes.loginRegister.login
import com.example.tubes.loginRegister.register
import com.example.tubes.profile.editProfile
import com.example.tubes.profile.profile
import com.example.tubes.profile.settingsActivity
import com.example.tubes.papkops.papKops
import com.example.tubes.sore.sore

@Composable
fun mainStart(){
    val navController = rememberNavController()
    val userName = "Nama_pengguna"

    NavHost(navController = navController, startDestination = Route.login //Route.register //Route.sore
        , builder = {
            composable (Route.login){
                login(navController)
            }
            composable (Route.register){
                register(navController)
            }

            composable(
                route = Route.sore,
                arguments = listOf(
                    navArgument("userId") { type = NavType.StringType },
                    navArgument("username") { type = NavType.StringType }
                )
            ) { backStackEntry ->
                val userId = backStackEntry.arguments?.getString("userId")!!
                val username = backStackEntry.arguments?.getString("username")!!

                sore(navController, userId, username)
            }

            composable (Route.gangMatch,
                arguments = listOf(
                navArgument("userId") { type = NavType.StringType },
                navArgument("username") { type = NavType.StringType }
            )
            ) { backStackEntry ->
                val userId = backStackEntry.arguments?.getString("userId")!!
                val username = backStackEntry.arguments?.getString("username")!!
                gangMatch(navController, userId, username)
            }

            composable (Route.mainProfile,
                arguments = listOf(
                    navArgument("userId") { type = NavType.StringType },
                    navArgument("username") { type = NavType.StringType }
                )
            ) { backStackEntry ->
                val userId = backStackEntry.arguments?.getString("userId")!!
                val username = backStackEntry.arguments?.getString("username")!!
                profile(navController, userId, username)
            }
            composable(Route.editProfile) {
                editProfile(navController, userName,null,"apa saja yang penting bio")
            }
            composable(Route.settingsActivity) {
                settingsActivity(navController)
            }
            composable(Route.invite) {
                invite(navController)
            }
            composable(Route.papKops,
                    arguments = listOf(
                    navArgument("userId") { type = NavType.StringType },
                    navArgument("username") { type = NavType.StringType }
            )
            ) { backStackEntry ->
                val userId = backStackEntry.arguments?.getString("userId")!!
                val username = backStackEntry.arguments?.getString("username")!!
                papKops(navController,userId, username)
            }


        })

}