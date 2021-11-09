package post.properties.attachments.data

import post.properties.attachments.interfaces.DocAttachment

data class Doc(val doc: Any?,
               override val id: Int,
               override val format: String,
               override val content: String,
               override val type: String = "doc"
               ):DocAttachment
