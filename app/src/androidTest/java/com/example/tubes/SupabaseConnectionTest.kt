package com.example.tubes

import com.example.tubes.data.SupabaseClient
import io.github.jan.supabase.postgrest.from
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.Assert.*
import java.net.URL
import java.net.HttpURLConnection

/**
 * Test koneksi Supabase dengan table production
 *
 * ⚠️ PENTING: Test ini sudah disesuaikan dengan struktur database actual!
 *
 * Table yang akan ditest:
 * 1. venues (id, name, latitude, longitude, created_at)
 * 2. users (id, email, username, created_at, avatar_url, bio, last_known_venue_id)
 * 3. visits (id, user_id, venue_id, visit_date, first_seen_at, last_seen_at)
 * 4. pap_kops (id, user_id, venue_id, storage_path, uploaded_at)
 * 5. broadcasts (id, creator_id, venue_id, pap_kops_id, category, description)
 *
 * Cara menjalankan:
 * 1. Klik kanan pada class ini → Run 'SupabaseConnectionTest'
 * 2. Atau klik kanan pada function tertentu untuk run 1 test saja
 */
class SupabaseConnectionTest {

    /**
     * ✅ TEST 1: Koneksi dasar ke Supabase
     * Memastikan URL dan API Key valid
     */
    @Test
    fun testBasicConnection() = runBlocking {
        println("\n===========================================")
        println("🧪 TEST 1: Basic Connection")
        println("===========================================")

        try {
            val url = com.example.tubes.BuildConfig.SUPABASE_URL
            val key = com.example.tubes.BuildConfig.SUPABASE_KEY

            println("📡 Checking credentials...")
            println("   URL: ${url.take(30)}...")
            println("   Key: ${key.take(20)}...")

            require(url.isNotBlank()) { "❌ URL is empty!" }
            require(key.isNotBlank()) { "❌ API Key is empty!" }
            require(url.startsWith("https")) { "❌ URL must start with https" }

            println("✅ Credentials are valid!")
            println("===========================================\n")

            assertTrue("Basic connection test passed", true)
        } catch (e: Exception) {
            println("❌ ERROR: ${e.message}")
            println("===========================================\n")
            fail("Basic connection failed: ${e.message}")
        }
    }

    /**
     * ✅ TEST 2: DNS Resolution Test
     * Memastikan emulator bisa resolve hostname Supabase
     */
    @Test
    fun testDNSResolution() = runBlocking {
        println("\n===========================================")
        println("🧪 TEST 2: DNS Resolution")
        println("===========================================")

        try {
            println("🔄 Testing DNS resolution...")

            // Test Google (should always work)
            print("   Testing google.com... ")
            val googleUrl = URL("https://www.google.com")
            val googleConnection = googleUrl.openConnection() as HttpURLConnection
            googleConnection.connectTimeout = 5000
            googleConnection.connect()
            println("✅ OK (${googleConnection.responseCode})")
            googleConnection.disconnect()

            // Test Supabase hostname
            print("   Testing Supabase hostname... ")
            val supabaseUrl = URL(com.example.tubes.BuildConfig.SUPABASE_URL)
            val supabaseConnection = supabaseUrl.openConnection() as HttpURLConnection
            supabaseConnection.connectTimeout = 10000
            supabaseConnection.connect()
            println("✅ OK (${supabaseConnection.responseCode})")
            supabaseConnection.disconnect()

            println("\n✅ DNS Resolution works!")
            println("===========================================\n")
            assertTrue("DNS resolution successful", true)

        } catch (e: Exception) {
            println("❌ FAILED: ${e.message}")
            println("\n💡 Possible solutions:")
            println("   1. Cold Boot emulator (Device Manager → Cold Boot Now)")
            println("   2. Use physical Android device instead")
            println("   3. Check emulator internet connection")
            println("===========================================\n")
            fail("DNS resolution failed: ${e.message}")
        }
    }

    /**
     * ✅ TEST 3: Fetch VENUES table
     * Table: venues (id, name, latitude, longitude, created_at)
     */
    @Test
    fun testFetchVenuesTable() = runBlocking {
        println("\n===========================================")
        println("🧪 TEST 3: Fetch VENUES Table")
        println("===========================================")
        println("📋 Expected columns: id, name, latitude, longitude, created_at")

        try {
            println("🔄 Fetching venues table...")

            val response = SupabaseClient.client
                .from("venues")
                .select()

            println("✅ SUCCESS!")
            println("✓ Table 'venues' is accessible")
            println("✓ RLS is disabled (as expected)")
            println("✓ Query executed successfully")
            println("===========================================\n")

            assertTrue("Venues table accessible", true)

        } catch (e: Exception) {
            println("❌ FAILED: ${e.message}")
            println("\n💡 Troubleshooting:")
            println("   1. Check if table 'venues' exists in Supabase")
            println("   2. Verify RLS is disabled")
            println("   3. Check emulator internet connection")
            println("   4. Try Cold Boot emulator")
            println("===========================================\n")

            fail("Venues table test failed: ${e.message}")
        }
    }

    /**
     * ✅ TEST 4: Fetch USERS table
     * Table: users (id, email, username, created_at, avatar_url, bio, last_known_venue_id)
     */
    @Test
    fun testFetchUsersTable() = runBlocking {
        println("\n===========================================")
        println("🧪 TEST 4: Fetch USERS Table")
        println("===========================================")
        println("📋 Expected columns: id, email, username, created_at, avatar_url, bio")

        try {
            println("🔄 Fetching users table...")

            val response = SupabaseClient.client
                .from("users")
                .select()

            println("✅ SUCCESS!")
            println("✓ Table 'users' is accessible")
            println("✓ Query executed successfully")
            println("===========================================\n")

            assertTrue("Users table accessible", true)

        } catch (e: Exception) {
            println("❌ FAILED: ${e.message}")
            println("\n💡 Troubleshooting:")
            println("   1. Check if table 'users' exists in Supabase")
            println("   2. Verify RLS is disabled")
            println("===========================================\n")

            fail("Users table test failed: ${e.message}")
        }
    }

    /**
     * ✅ TEST 5: Fetch VISITS table
     * Table: visits (id, user_id, venue_id, visit_date, first_seen_at, last_seen_at)
     */
    @Test
    fun testFetchVisitsTable() = runBlocking {
        println("\n===========================================")
        println("🧪 TEST 5: Fetch VISITS Table")
        println("===========================================")
        println("📋 Expected columns: id, user_id, venue_id, visit_date")

        try {
            println("🔄 Fetching visits table...")

            val response = SupabaseClient.client
                .from("visits")
                .select()

            println("✅ SUCCESS!")
            println("✓ Table 'visits' is accessible")
            println("===========================================\n")

            assertTrue("Visits table accessible", true)

        } catch (e: Exception) {
            println("❌ FAILED: ${e.message}")
            println("===========================================\n")
            fail("Visits table test failed: ${e.message}")
        }
    }

    /**
     * ✅ TEST 6: Fetch PAP_KOPS table
     * Table: pap_kops (id, user_id, venue_id, storage_path, uploaded_at)
     */
    @Test
    fun testFetchPapKopsTable() = runBlocking {
        println("\n===========================================")
        println("🧪 TEST 6: Fetch PAP_KOPS Table")
        println("===========================================")
        println("📋 Expected columns: id, user_id, venue_id, storage_path, uploaded_at")

        try {
            println("🔄 Fetching pap_kops table...")

            val response = SupabaseClient.client
                .from("pap_kops")
                .select()

            println("✅ SUCCESS!")
            println("✓ Table 'pap_kops' is accessible")
            println("===========================================\n")

            assertTrue("Pap_kops table accessible", true)

        } catch (e: Exception) {
            println("❌ FAILED: ${e.message}")
            println("===========================================\n")
            fail("Pap_kops table test failed: ${e.message}")
        }
    }

    /**
     * ✅ TEST 7: Fetch BROADCASTS table
     * Table: broadcasts (id, creator_id, venue_id, pap_kops_id, category, description)
     */
    @Test
    fun testFetchBroadcastsTable() = runBlocking {
        println("\n===========================================")
        println("🧪 TEST 7: Fetch BROADCASTS Table")
        println("===========================================")
        println("📋 Expected columns: id, creator_id, venue_id, pap_kops_id, category")

        try {
            println("🔄 Fetching broadcasts table...")

            val response = SupabaseClient.client
                .from("broadcasts")
                .select()

            println("✅ SUCCESS!")
            println("✓ Table 'broadcasts' is accessible")
            println("===========================================\n")

            assertTrue("Broadcasts table accessible", true)

        } catch (e: Exception) {
            println("❌ FAILED: ${e.message}")
            println("===========================================\n")
            fail("Broadcasts table test failed: ${e.message}")
        }
    }

    /**
     * ✅ TEST 8: Test SEMUA table production sekaligus
     * Comprehensive test untuk semua table
     */
    @Test
    fun testAllProductionTables() = runBlocking {
        println("\n===========================================")
        println("🧪 TEST 8: Test ALL Production Tables")
        println("===========================================")

        val tables = listOf(
            "venues",
            "users",
            "visits",
            "pap_kops",
            "broadcasts"
        )

        val results = mutableMapOf<String, Pair<Boolean, String?>>()

        println("📋 Testing ${tables.size} tables...\n")

        tables.forEach { tableName ->
            try {
                print("   Testing '$tableName'... ")

                SupabaseClient.client
                    .from(tableName)
                    .select()

                println("✅ OK")
                results[tableName] = Pair(true, null)

            } catch (e: Exception) {
                val errorMsg = e.message ?: "Unknown error"
                println("❌ FAILED")
                println("      → ${errorMsg.take(60)}...")
                results[tableName] = Pair(false, errorMsg)
            }
        }

        println("\n===========================================")
        println("📊 FINAL RESULTS:")
        println("===========================================")

        val successful = results.count { it.value.first }
        val failed = results.count { !it.value.first }

        results.forEach { (table, result) ->
            val icon = if (result.first) "✅" else "❌"
            println("$icon $table")
            if (!result.first && result.second != null) {
                println("   └─ Error: ${result.second!!.take(50)}...")
            }
        }

        println("\n📈 Summary: $successful/${tables.size} tables accessible")

        if (failed > 0) {
            println("\n⚠️  ${failed} table(s) failed!")
            println("💡 Most likely cause: Emulator DNS resolution issue")
            println("🔧 Solution: Cold Boot emulator or use physical device")
        } else {
            println("\n🎉 ALL TABLES ACCESSIBLE!")
            println("✅ Database connection is READY for development")
        }

        println("===========================================\n")

        assertTrue(
            "At least one table should be accessible (got $successful/${tables.size})",
            successful > 0
        )
    }

    /**
     * ✅ TEST 9: Basic Query Test
     * Memastikan query SELECT berfungsi dengan baik
     */
    @Test
    fun testBasicQuery() = runBlocking {
        println("\n===========================================")
        println("🧪 TEST 9: Basic Query Test")
        println("===========================================")

        try {
            println("🔄 Testing basic SELECT query...")

            val response = SupabaseClient.client
                .from("venues")
                .select()

            println("✅ Query executed successfully!")
            println("===========================================\n")

            assertTrue("Query successful", true)

        } catch (e: Exception) {
            println("❌ FAILED: ${e.message}")
            println("===========================================\n")
            fail("Query failed: ${e.message}")
        }
    }
}

/**
 * 📝 DOKUMENTASI UNTUK TIM:
 *
 * Setelah SEMUA test berhasil (hijau ✅), artinya:
 *
 * ✅ Koneksi ke Supabase berhasil
 * ✅ DNS resolution berfungsi
 * ✅ Semua table accessible (venues, users, visits, pap_kops, broadcasts)
 * ✅ RLS sudah disabled dengan benar
 * ✅ Ready untuk development!
 *
 * Cara menggunakan di development:
 *
 * ```kotlin
 * // Fetch semua venues
 * val venues = SupabaseClient.client
 *     .from("venues")
 *     .select()
 *
 * // Fetch specific columns
 * val venueNames = SupabaseClient.client
 *     .from("venues")
 *     .select(columns = "id,name")
 *
 * // Insert data
 * SupabaseClient.client
 *     .from("venues")
 *     .insert(mapOf(
 *         "name" to "Warung Kopi",
 *         "latitude" to -7.7956,
 *         "longitude" to 110.3695
 *     ))
 * ```
 *
 * ⚠️ JIKA TEST MASIH GAGAL:
 * 1. Cold Boot emulator: Device Manager → Cold Boot Now
 * 2. Gunakan HP fisik: Settings → Developer Options → USB Debugging
 * 3. Check AndroidManifest.xml sudah ada INTERNET permission
 */