package post.properties.attachments.interfaces

interface VideoAttachment: Attachments {
    val id:Int
    val ownerId:Int
    val videoPreview:String
    val fullSizeVideo:String
}