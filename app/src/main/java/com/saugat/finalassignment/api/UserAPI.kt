package com.saugat.finalassignment.api

import com.saugat.finalassignment.entity.User
import com.saugat.finalassignment.response.GetUserProfileResponse
import com.saugat.finalassignment.response.ImageResponse
import com.saugat.finalassignment.response.LoginResponse
import okhttp3.MultipartBody
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

    @Multipart
    @PUT("/user/{id}/photo")
    suspend fun userImageUpload(
            @Header("Authorization") token: String,
            @Path("id") id: String,
            @Part file: MultipartBody.Part
    ): Response<ImageResponse>
}