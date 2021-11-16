package Notes

data class Comment(val id:Int,val text:String, val noteId:Int, var isDeleted:Boolean = false)
