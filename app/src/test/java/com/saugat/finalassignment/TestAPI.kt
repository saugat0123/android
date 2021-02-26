package com.saugat.finalassignment

import com.saugat.finalassignment.entity.User
import com.saugat.finalassignment.repository.UserRepo
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class TestAPI {

    private lateinit var userRepo: UserRepo
    //private lateinit var studentRepository: StudentRepository
    // -----------------------------User Testing-----------------------------
    @Test
    fun checkLogin() = runBlocking {
        userRepo = UserRepo()
        val response = userRepo.loginUser("saugat@gmail.com","aaaaaa")
        val expectedResult = true
        val actualResult = response.success
        Assert.assertEquals(expectedResult, actualResult)
    }
    @Test
    fun registerUser() = runBlocking {
        val user =
                User(firstName = "test", lastName = "test", password = "test", address = "test", phone  = "test", email  = "test",)
        userRepo = UserRepo()
        val response = userRepo.registerUser(user)
        val expectedResult = true
        val actualResult = response.success
        Assert.assertEquals(expectedResult, actualResult)
    }
    // -----------------------------Student Testing-----------------------------
//    @Test
//    fun addStudent() = runBlocking {
//        userRepo = UserRepository()
//        studentRepository = StudentRepository()
//        val student =
//                Student(fullname = "fullName", age = 33, gender = "gender", address = "address")
//        ServiceBuilder.token ="Bearer " + userRepo.checkUser("kiran","kiran123").token
//        val expectedResult = true
//        val actualResult = studentRepository.insertStudent(student).success
//        Assert.assertEquals(expectedResult, actualResult)
//    }

}