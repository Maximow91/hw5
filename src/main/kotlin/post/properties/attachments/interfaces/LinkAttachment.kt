package post.properties.attachments.interfaces

interface LinkAttachment: Attachments {
    val id: Int
    val ownerId:Int
    val link:String
}