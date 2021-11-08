package post.properties.attachments.interfaces

interface AudioAttachment: Attachments {
    val name:String
    val author:String
    val bitRate:Int
}