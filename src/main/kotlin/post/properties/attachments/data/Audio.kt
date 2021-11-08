package post.properties.attachments.data

import post.properties.attachments.interfaces.AudioAttachment

data class Audio(
                 override val name: String,
                 override val author: String,
                 override val bitRate: Int,
                 override val type: String ="audio",
                 ):AudioAttachment
