package post.properties.attachments.interfaces

interface DocAttachment:Attachments {
    val id:Int
    val format:String
    val content:String
}