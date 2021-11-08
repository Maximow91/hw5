package post.properties.attachments.data

import post.properties.attachments.interfaces.Attachments
import post.properties.attachments.interfaces.AudioAttachment

class Attachment(override val type: String): Attachments {
    var array:Array<Attachments> = emptyArray()
    val typeAttachments = when (type){
        "audio" -> AudioAttachment
    }
}