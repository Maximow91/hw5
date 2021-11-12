import post.properties.CopyHistory
import post.properties.Geo
import post.properties.PostSourse
import post.properties.attachments.interfaces.Attachments
import java.util.*

data class Post(
    val id: Int,
    val ownerId: Int,
    val fromId: Int,
    val createdBy: Int,
    val date: Int,
    val text: String,
    val replyOwnerId: Int,
    val replyPostId: Int,
    val friendsOnly: Boolean,
    val comments: Any?,
    val copyright: Any,
    val likes: Any,
    val reposts: Any,
    val views: Any,
    val postType: String,
    val singerId: Int,
    val canPin: Boolean,
    val canDelete: Boolean,
    val canEdit: Boolean,
    val isPinned: Boolean,
    val markedAsAds: Boolean,
    val isFavorite: Boolean,
    val donut: Any,
    val postponedId: Int,
    val postSourse: PostSourse?,
    val geo:Geo?,
    val copyHistory: CopyHistory?,
    val attachments: Attachments?,
    val postId:Int = 0,
)
