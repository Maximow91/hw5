package Notes.Servise

import Notes.Comment
import Notes.Note

class NoteNotFoundException(): RuntimeException()
class CommentNotFoundException(): RuntimeException()

object NotesService {
    private var notes = arrayListOf<Note>();
    private var comments = arrayListOf<Comment>();
    private var lastId = 1;
    private var idForTest = 1;
    private var isItemInArrayList = false
    private var  noteListForTest = arrayListOf<Note>()
    private var  commentListForTest = arrayListOf<Comment>()


    fun addNote(note: Note): Note {
        var newNote = note.copy(noteId = lastId)
        notes.add(newNote)
        lastId++
        return notes.last()
    }

    fun createComment(comment: Comment): Boolean {
        var newComment = comment.copy()
        var isNoteInList = false
        for (note in notes) {
            if (!note.isDeleted && note.id == comment.noteId) {
                comments += comment
                isNoteInList = true
            }
        }
        if(!isNoteInList) {
            throw NoteNotFoundException()
        }
        return isNoteInList
    }

    fun deleteNote(id:Int): Boolean {
        var found:Note? = notes.find {it.id == id}
        if (found != null) {
            found.isDeleted = true
            for (comment in comments) {
                if (found.id == comment.noteId) {
                    comment.isDeleted = true
                }
            }
        } else
            throw NoteNotFoundException()
        return found.isDeleted
    }

    fun editNote(note: Note): Boolean {
        var isNoteInList = false
        notes.forEachIndexed { index, oldNote ->
            if (!oldNote.isDeleted && oldNote.id == note.id) {
                isNoteInList = true
                notes[index] = oldNote.copy(date = note.date)
                return isNoteInList
            }
        }
        if(!isNoteInList) throw NoteNotFoundException()
        return isNoteInList
    }

    fun editComment(comment: Comment): Boolean {
        var isCommentInList = false
        comments.forEachIndexed { index, oldComment ->
            if (comment.id == oldComment.id && !oldComment.isDeleted) {
                isCommentInList = true
                comments[index] = comment
            }
        }
        if (!isCommentInList) throw CommentNotFoundException()
        return isCommentInList
    }


    fun getNoteList():ArrayList<Note> {
        return notes
    }

    fun getByld(id: Int): Note {
        var foundNote: Note = notes.find { it.id == id } ?: throw NoteNotFoundException()
        return foundNote
    }

    fun getComments(): List<Comment> {
        return comments
    }

    fun restoreComment(id: Int): Boolean {
        var foundComment = comments.find { it.id == id }
        if (foundComment != null) {
            isItemInArrayList = true
            foundComment.isDeleted = false
        } else {
            isItemInArrayList = false
            throw CommentNotFoundException()
        }
        return isItemInArrayList
    }

    fun clearListsForTests(){
        noteListForTest = notes.clone() as ArrayList<Note>
        commentListForTest = comments.clone() as ArrayList<Comment>
        notes.clear()
        comments.clear()
        lastId = 1
    }

    fun returnListsAfterTest(){
        notes = noteListForTest
        comments = commentListForTest
        lastId = idForTest
    }
}