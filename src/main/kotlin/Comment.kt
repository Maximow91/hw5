import post.properties.attachments.interfaces.Attachments

data class Comment(val id:Int,
                   val fromId:Int,
                   val postId:Int,
                   val date:Int,
                   val text:String,
                   val donut:Int,
                   val replyToUser:Int,
                   val replyToComment:Int,
                   val attachments: Attachments,
                   val parentsSack:Array<Int>?,
                   val thread: Any?)
