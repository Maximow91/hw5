object WallService  {
    private var posts = emptyArray<Post>()
    private var id: Int = 0

    fun addPost(post: Post): Post {
        id +=1
        post.postId = id
        posts += post.copy()
        return posts.last()
    }

    fun update(post: Post):Boolean {
        var modId = post.component1()
        var postToUpdate = post
        posts.forEachIndexed { index, post ->
            if (modId == post.id) {
                posts[index] = post.copy(
                    fromId = postToUpdate.fromId,
                    createdBy = postToUpdate.createdBy,
                    text = postToUpdate.text,
                    replyOwnerId = postToUpdate.replyOwnerId,
                    replyPostId = postToUpdate.replyPostId,
                    friendsOnly = postToUpdate.friendsOnly,
                    comments = postToUpdate.comments,
                    copyright = postToUpdate.copyright,
                    likes = postToUpdate.likes,
                    reposts = postToUpdate.reposts,
                    views = postToUpdate.views,
                    postType = postToUpdate.postType,
                    singerId = postToUpdate.singerId,
                    canPin = postToUpdate.canPin,
                    canDelete = postToUpdate.canDelete,
                    isPinned = postToUpdate.isPinned,
                    markedAsAds = postToUpdate.markedAsAds,
                    isFavorite = postToUpdate.isFavorite,
                    donut = postToUpdate.donut
                )
                return  true
            }
        }
        return false
    }
}