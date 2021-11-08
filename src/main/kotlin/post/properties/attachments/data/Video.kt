package post.properties.attachments.data

import post.properties.attachments.interfaces.Attachments
import post.properties.attachments.interfaces.VideoAttachment

data class Video (override val type:String = "video",
                  override val id: Int,
                  override val ownerId: Int,
                  override val fullSizeVideo: String,
                  override val videoPreview: String ):VideoAttachment
