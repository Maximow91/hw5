package post.properties

sealed class Attachments(val type:String)

data class VideoAttachments(val id: Int, val ownerId: Int, val videoPreview: String, val fullSizeVideo: String): Attachments("video")
data class AudioAttachments (val id:Int, val ownerId: Int, val format: String, val bitrate:Int): Attachments ("audio")
data class Doc(val id:Int, val format:String, val content: String): Attachments("doc")
data class Link(val id:String, val ownerId:Int, val link:String): Attachments("link")
data class Photo(val id: Int, val ownerId: Int, val photoPreview: String): Attachments("photo")


