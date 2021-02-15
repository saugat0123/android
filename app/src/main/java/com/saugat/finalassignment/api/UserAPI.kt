package com.saugat.finalassignment.api

import com.saugat.finalassignment.entity.User
import com.saugat.finalassignment.response.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface UserAPI {

    // Register User
    @POST ("/register")
    suspend fun registerUser(
            @Body user:User)
    :Response<LoginResponse>

    // Login User
    @FormUrlEncoded
    @POST ("/login")
    suspend fun checkUser(
            @Field ("email") email: String,
            @Field ("password") password: String
    ): Response<LoginResponse>
}