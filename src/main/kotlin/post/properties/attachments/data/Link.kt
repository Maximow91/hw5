package post.properties.attachments.data

import post.properties.attachments.interfaces.LinkAttachment

data class Link(override val type: String = "link",
                override val id: Int,
                override val ownerId: Int,
                override val link: String
                ):LinkAttachment
