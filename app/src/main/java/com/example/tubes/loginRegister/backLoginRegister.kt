package com.example.tubes.loginRegister

import android.util.Log
import com.example.tubes.data.SupabaseClient
import com.example.tubes.data.user.UserId
import com.example.tubes.data.user.UserLogin
import com.example.tubes.data.user.UserRegister
import io.github.jan.supabase.postgrest.from


suspend fun registerUser(
    username: String,
    email: String,
    password: String
): Boolean {

    if (isUsernameExists(username)) return false

    return try {
        SupabaseClient.client
            .from("users")
            .insert(
                UserRegister(
                    username = username,
                    email = email,
                    password = password,
                )
            )
        true
    } catch (e: Exception) {
        e.printStackTrace()
        Log.e("REGISTER_INSERT", e.message ?: "UNKNOWN ERROR")
        throw e
        false
    }
}


suspend fun isUsernameExists(username: String): Boolean {
        val result = SupabaseClient.client
            .from("users")
            .select {
                filter {
                    eq("username", username)
                }
                limit(1)
            }
            .decodeList<UserId>()

        return result.isNotEmpty()

}




suspend fun loginUser(
    username: String,
    password: String
): UserLogin? {

    val result = SupabaseClient.client
        .from("users")
        .select {
            filter {
                eq("username", username)
                eq("password", password)
            }
            limit(1)
        }
        .decodeList<UserLogin>()

    return result.firstOrNull()
}




