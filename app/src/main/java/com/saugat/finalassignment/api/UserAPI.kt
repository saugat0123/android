package com.saugat.finalassignment.api

import com.saugat.finalassignment.entity.User
import com.saugat.finalassignment.response.GetUserProfileResponse
import com.saugat.finalassignment.response.LoginResponse
import retrofit2.Response
import retrofit2.http.*

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

    @GET("/me")
    suspend fun getMe(
            @Header ("Authorization") token: String,
    ): Response<GetUserProfileResponse>
}