data class Broadcast(
    val id: String,
    val creator_id: String,
    val venue_id: String,
    val category: String,
    val description: String,
    val is_active: Boolean,
    val location_description: String?,
    val created_at: String?
)
