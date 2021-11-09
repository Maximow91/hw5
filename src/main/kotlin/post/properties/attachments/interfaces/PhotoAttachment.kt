package post.properties.attachments.interfaces

interface PhotoAttachment: Attachments {
    val id:Int
    val ownerId:Int
    val photoPreview:String
    val fullSizePhoto:String
}