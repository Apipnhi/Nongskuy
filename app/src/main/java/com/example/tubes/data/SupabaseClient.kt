package com.example.tubes.data

import com.example.tubes.BuildConfig
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.auth.Auth
import io.ktor.client.engine.okhttp.OkHttp

object SupabaseClient {
    val client = createSupabaseClient(
        supabaseUrl = BuildConfig.SUPABASE_URL,
        supabaseKey = BuildConfig.SUPABASE_KEY
    ) {
        // PAKAI INI: Untuk memaksa menggunakan OkHttp engine
        // Ini akan membantu mengatasi masalah "No address associated with hostname"
        httpEngine = OkHttp.create()

        install(Postgrest)
        install(Auth)
    }
}