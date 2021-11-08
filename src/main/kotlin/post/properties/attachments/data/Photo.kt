package post.properties.attachments.data

import post.properties.attachments.interfaces.PhotoAttachment

data class Photo(override val type: String = "photo",
                 override val id: Int,
                 override val ownerId: Int,
                 override val photoPreview: String,
                 override val fullSizePhoto: String): PhotoAttachment