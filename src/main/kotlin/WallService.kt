object WallService  {
    private var posts = emptyArray<Post>()
    private var lastId: Int = 1
    val arrForTest = posts.clone()

    fun addPost(post: Post): Post {
        val newPost = post.copy(postId = lastId)
        posts += newPost
        lastId ++
        return posts.last()
    }

    fun update(post: Post):Boolean {
        var isPostInArray = false
        for((idex,oldPost) in posts.withIndex()){
            if(post.id === oldPost.id) {
                posts[idex]= post.copy(ownerId = oldPost.ownerId, date = oldPost.date)
                isPostInArray = true
            }
        }
        return isPostInArray
    }

}