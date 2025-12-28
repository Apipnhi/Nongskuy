import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id: String?,
    val username: String?,
    val email: String?,
    val password: String?,
    val avatar_url: String?,
    val last_known_venue_id: String?,
    val created_at: String?
)
