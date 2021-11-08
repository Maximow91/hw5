package post.properties.attachments.data

import post.properties.attachments.interfaces.Attachments
import post.properties.attachments.interfaces.VideoAttachment

data class Video (override val id: Int,
                  override val ownerId: Int,
                  override val fullSizeVideo: String,
                  override val videoPreview: String,
                  override val type:String = "video"):VideoAttachment
