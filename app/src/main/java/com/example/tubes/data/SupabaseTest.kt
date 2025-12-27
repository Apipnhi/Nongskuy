package com.example.tubes.data

import android.util.Log
import com.example.tubes.BuildConfig
import io.github.jan.supabase.postgrest.from
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

object SupabaseTest {
    private const val TAG = "SupabaseTest"

    fun quickTest() {
        Log.d(TAG, "=== SUPABASE CONNECTION TEST ===")

        Log.d(TAG, "SUPABASE_URL: ${BuildConfig.SUPABASE_URL}")
        Log.d(TAG, "SUPABASE_KEY length: ${BuildConfig.SUPABASE_KEY.length}")

        if (BuildConfig.SUPABASE_URL.isEmpty()) {
            Log.e(TAG, "❌ SUPABASE_URL is empty!")
            return
        }

        if (BuildConfig.SUPABASE_KEY.isEmpty()) {
            Log.e(TAG, "❌ SUPABASE_KEY is empty!")
            return
        }

        CoroutineScope(Dispatchers.IO).launch {
            try {
                Log.d(TAG, "🔄 Fetching data from Supabase...")

                val response = SupabaseClient.client
                    .from("test_users")
                    .select()
                    .decodeList<TestUser>()

                Log.d(TAG, "✅ SUCCESS! Fetched ${response.size} records")
                response.forEach { user ->
                    Log.d(TAG, "   User: ID=${user.id}, Name=${user.name}")
                }

            } catch (e: Exception) {
                Log.e(TAG, "❌ ERROR: ${e.message}", e)
            }
        }
    }
}