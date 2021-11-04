package ru.netology

import Post
import WallService.addPost
import WallService.arrForTest
import WallService.update
import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {
    val testPost = Post(1,12,15,232,1,
        "Text",1,2,true,12,
        1,1,1,1,"type",1,
        true,true,true,true,
        true,true,1,1)

    val testPostSecond = Post(2,2,2,2,2,
    "text",2,2,true,2,
        2,2,2,2,"type",2,
    true,true,true,true,
    true,true,2,2)

    val testPostThird = Post (3,3,3,3,3,
    "text",3,3,true,3,
    3,3,3,3,"type",3,
    true,true,true,true,
    true,true,3,3)

    val testPostWithoutExistingId = Post(99,1,1,1,12,
        "text",7, 7,true,7,
        7,7,7,7,"type", 7,
        true,true,true,true,
        true,true,7,7 )

    val testPostToUpdate = Post(1,8,8,8,8,
    "text",8,8,true,8,
    8,8,8,8,"type",8,
    true,true,true,true,
    true,true,8,8)


    @Test
    fun addPostTest () {
        val result = addPost(testPost)
        val testRes = addPost(testPostSecond)
        assertNotEquals(result.postId, 0)

    }

    @Test
    fun testUpdate() {
        val testArr = arrForTest.toMutableList()
        testArr.clear()
        testArr.toTypedArray()
        addPost(testPost)
        addPost(testPost)
        addPost(testPostSecond)
        addPost(testPostThird)

        val noUpdate = update(testPostWithoutExistingId)

        assertEquals(noUpdate, false)

        val up = update(testPostToUpdate)

        assertEquals(up, true)




    }
}