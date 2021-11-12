
class PostNotFoundException(): RuntimeException()
class CommentNotFoundException(message:String):RuntimeException(message)

object WallService {
    private var posts = emptyArray<Post>()
    private var lastId: Int = 1
    private var comments = emptyArray<Comment>()
    private var reports = emptyArray<Report>()
    private var testArray = emptyArray<Post>()
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

    fun createComment(comment: Comment):Boolean {
        val newComment = comment.copy()
        var isPostInArray = false
        for(post in posts){
            if(post.id == comment.postId){
                comments += newComment
                isPostInArray = true
            }
        }
        if(!isPostInArray) {
            throw PostNotFoundException()
        }
        return isPostInArray
    }

    fun reportComment(report:Report):Boolean {
        val newReport = report.copy()
        var isCommentInArray = false
        for(comment in comments){
            if(comment.id == report.commentId){
                reports += newReport
                isCommentInArray = true
            }
        }
        if(!isCommentInArray) throw CommentNotFoundException("Комментарий с id ${report.commentId} не найден, возможно был удалён ранее")
        return isCommentInArray
    }

    fun deleteArray() {
        testArray = posts.copyOf()
        posts = emptyArray()
    }

    fun returnArray(){
        posts = testArray
    }

}

