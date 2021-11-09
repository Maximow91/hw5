package ru.netology

import Comment
import CommentNotFoundException
import Post
import PostNotFoundException
import Report
import WallService.addPost
import WallService.createComment
import WallService.update
import org.junit.After
import org.junit.Test

import org.junit.Assert.*
import post.properties.attachments.data.Audio
import post.properties.attachments.data.Video
import post.properties.attachments.interfaces.Attachments
import post.properties.attachments.interfaces.AudioAttachment
import post.properties.attachments.interfaces.VideoAttachment
import kotlin.test.AfterTest

class WallServiceTest {


    val attachmentsForTest = Video("Video",1,2,"fullSize","preview")
    val reportForTest = Report(1,1,0)
    val reportForTestSecond = Report(2,2,0)
    val commentForTest = Comment(1,2,1,1,"comment",1,2,3,attachmentsForTest,null,null)
    val commentForExceptionTest = Comment(1,2,100,1,"comment",1,2,3,attachmentsForTest,null,null)
    val testPost = Post(8,12,15,232,1,
        "Text",1,2,true,null,
        1,1,1,1,"type",1,
        true,true,true,true,
        true,true,1,1,null,null,null,Audio(null,"song","vasia",128))

    val testPostSecond = Post(1,2,2,2,2,
    "text",2,2,true,2,
        2,2,2,2,"type",2,
    true,true,true,true,
    true,true,2,2,null,null,null,Audio(null,"song","vasia",128))

    val testPostThird = Post (3,3,3,3,3,
    "text",3,3,true,3,
    3,3,3,3,"type",3,
    true,true,true,true,
    true,true,3,3,null,null,null,Audio(null,"song","vasia",128))

    val testPostWithoutExistingId = Post(99,1,1,1,12,
        "text",7, 7,true,7,
        7,7,7,7,"type", 7,
        true,true,true,true,
        true,true,7,7,null,null,null,Audio(null,"song","vasia",128) )

    val testPostToUpdate = Post(1,8,8,8,8,
    "text",8,8,true,8,
    8,8,8,8,"type",8,
    true,true,true,true,
    true,true,8,8,null,null,null,Audio(null,"song","vasia",128))


    @Test
    fun addPostTest () {
        val result = addPost(testPost)
        val testRes = addPost(testPostSecond)
        assertNotEquals(result.postId, 0)
    }


    @Test
    fun testUpdate() {
        WallService.deleteArray()
        addPost(testPost)
        addPost(testPostSecond)
        addPost(testPostThird)

        val noUpdate = update(testPostWithoutExistingId)

        assertEquals(noUpdate, false)

        val up = update(testPostToUpdate)

        assertEquals(up, true)
    }

    @Test
    fun testCreateComment() {
        WallService.addPost(testPostSecond)
        val res = WallService.createComment(commentForTest)
        assertEquals(res,true)
    }


    @Test(expected = PostNotFoundException::class)
    fun shouldThrow() {
        WallService.deleteArray()
        WallService.addPost(testPostSecond)
        createComment(commentForExceptionTest)
    }

    @Test
    fun reportCommentTest(){
        WallService.addPost(testPost)
        WallService.addPost(testPostSecond)
        WallService.createComment(commentForTest)
        val res = WallService.reportComment(reportForTest)
        assertEquals(res,true)
    }

    @Test(expected = CommentNotFoundException::class)
    fun shouldThrowCommentNotFound() {
        WallService.reportComment(reportForTestSecond)
    }
    @After
    fun returnArray(){
        WallService.returnArray()
    }




}
