
import kotlinx.serialization.Serializable

@Serializable
data class Visit(
    val id: String,
    val user_id: String,
    val venue_id: String,
    val visit_date: String,
    val visit_count_in_day: Int,
    val status: Boolean,
    val created_at: String?
)
