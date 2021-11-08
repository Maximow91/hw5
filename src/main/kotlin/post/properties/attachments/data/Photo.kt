package post.properties.attachments.data

import post.properties.attachments.interfaces.PhotoAttachment

data class Photo(override val id: Int,
                 override val ownerId: Int,
                 override val photoPreview: String,
                 override val fullSizePhoto: String,
                 override val type: String = "photo"): PhotoAttachment