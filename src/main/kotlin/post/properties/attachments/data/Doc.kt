package post.properties.attachments.data

import post.properties.attachments.interfaces.DocAttachment

data class Doc(override val type: String = "doc",
               override val id: Int,
               override val format: String,
               override val content: String):DocAttachment
