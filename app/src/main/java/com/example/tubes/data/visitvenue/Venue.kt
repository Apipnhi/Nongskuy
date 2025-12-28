import kotlinx.serialization.Serializable

@Serializable
data class Venue(
    val id: String,
    val name: String,
    val latitude: Double,
    val longitude: Double,
    val created_at: String? = null
)
