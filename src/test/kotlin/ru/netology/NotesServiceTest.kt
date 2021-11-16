package ru.netology

import Notes.Comment
import Notes.Note
import Notes.Servise.CommentNotFoundException
import Notes.Servise.NoteNotFoundException
import Notes.Servise.NotesService
import org.junit.*

import org.junit.Assert.*
import kotlin.test.AfterTest
import kotlin.test.assertContains


class NotesServiceTest {

    val testNoteFirst = Note(1,2,"firstNote","text",10,
        1,5,"http//",null,null,
        2,"textWiki",null,1)

    val testNoteSecond = Note(2,3,"Note","text",13,
        1,5,"http//",null,null,
        2,"textWiki",null)

    val testNoteThird = Note(3,3,"Note","text",13,
        1,5,"http//",null,null,
        2,"textWiki",null)

    val testNote = Note(1,5,"Note232323","text",13,
        1,5,"http//",null,null,
        2,"textWiki",null)

    val testCommentFirst = Comment(1,"comment",1)
    val testCommentSecond = Comment(2,"comment",2)
    val testCommentThird = Comment(3,"comment",100)
    val testComment = Comment(1,"edited comment",1)


    @Before
    fun print(){
        NotesService.clearListsForTests()
        NotesService.addNote(testNoteFirst)
        NotesService.addNote(testNoteSecond)

    }

    @Test
    fun addNoteTest() {
        var result = NotesService.addNote(testNoteThird)

        assertEquals(result.noteId, 3 )
    }

    @Test
    fun createCommentTest() {
        NotesService.createComment(testCommentFirst)
        var result = NotesService.createComment(testCommentSecond)
        assertEquals(result, true)
    }

    @Test(expected = NoteNotFoundException::class)
    fun shouldThrow() {
        NotesService.createComment(testCommentThird)
    }

    @Test
    fun deleteNoteTest() {
        var result = NotesService.deleteNote(1)

        assertEquals(result, true)
    }

    @Test(expected = NoteNotFoundException::class)
    fun shouldThrowExcp() {
        NotesService.deleteNote(10)
    }

    @Test
    fun editNoteTest() {
        var result = NotesService.editNote(testNote)

        assertEquals(result, true)
    }

    @Test(expected = NoteNotFoundException::class)
    fun shouldThrowNoteNotFound() {
        NotesService.editNote(testNoteThird)
    }

    @Test
    fun editComment() {
        NotesService.createComment(testCommentFirst)
        NotesService.createComment(testCommentSecond)
        var result = NotesService.editComment(testComment)
        assertEquals(result, true)
    }

    @Test(expected = CommentNotFoundException::class)
    fun shouldThrowCommentNotFound() {
        NotesService.createComment(testCommentFirst)
        NotesService.createComment(testCommentSecond)
        NotesService.editComment(testCommentThird)
    }

    @Test
    fun getNoteListTest() {
        NotesService.clearListsForTests()
        var result = NotesService.getNoteList()
        assertEquals(result, arrayListOf<Note>())

    }

    @Test
    fun getByldTest() {
        var result = NotesService.getByld(1)

        assertEquals(result, testNoteFirst)
    }

    @Test
    fun getCommentsTest() {
        var result = NotesService.getComments()

        assertEquals(result, arrayListOf<Comment>())
    }

    @Test
    fun restoreCommentTest() {
        NotesService.createComment(testCommentFirst)
        var result = NotesService.restoreComment(1)

        assertEquals(result,true)
    }

    @Test(expected = CommentNotFoundException::class)
    fun shouldThrowCommentNotFoundInRestore() {
        NotesService.restoreComment(2)
    }

    @After
    fun returnLists(){
        NotesService.returnListsAfterTest()
    }
}