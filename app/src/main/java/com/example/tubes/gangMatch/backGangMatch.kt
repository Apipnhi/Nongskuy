import com.example.tubes.data.SupabaseClient
import io.github.jan.supabase.postgrest.from
import io.github.jan.supabase.postgrest.query.Columns


suspend fun getCurrentVenueId(userId: String): String? {
    return SupabaseClient.client
        .from("visits")
        .select {
            filter {
                eq("user_id", userId)
                eq("is_active", true)
            }
            limit(1)
        }
        .decodeList<Visit>()
        .firstOrNull()
        ?.venue_id
}

suspend fun getActiveBroadcastsAtMyPlace(
    userId: String
): List<BroadcastWithUser> {

    val venueId = getCurrentVenueId(userId) ?: return emptyList()

    return SupabaseClient.client
        .from("broadcasts")
        .select(
            Columns.raw(
                """
        id,
        creator_id,
        venue_id,
        category,
        description,
        is_active,
        users (
            id,
            username,
        )
        """
            )
        ) {
            filter {
                eq("venue_id", venueId)
                eq("is_active", true)
                neq("creator_id", userId)
            }
        }
        .decodeList()
}

