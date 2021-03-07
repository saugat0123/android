package com.saugat.finalassignment

import com.saugat.finalassignment.repository.UserRepo
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class RbTest {

    @Test
    fun checkLogin() = runBlocking{
        val userRepo = UserRepo()
        val response = userRepo.loginUser("admin@gmail.com", "admin123")
        val expectedResult = true
        val actualResult = response.success
        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun registerUser()= runBlocking {

    }
}