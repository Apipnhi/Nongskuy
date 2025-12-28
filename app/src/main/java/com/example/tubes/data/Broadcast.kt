
import com.example.tubes.data.user.UserLogin
import kotlinx.serialization.Serializable

@Serializable
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

@Serializable
data class BroadcastWithUser(
    val id: String,
    val creator_id: String,
    val venue_id: String,
    val category: String,
    val description: String,
    val is_active: Boolean,
    val users: UserLogin
)

