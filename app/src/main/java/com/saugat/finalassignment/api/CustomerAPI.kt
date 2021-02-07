package com.saugat.finalassignment.api

import com.saugat.finalassignment.entity.Customer
import com.saugat.finalassignment.response.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.POST

interface CustomerAPI {

    // Register Customer
    @POST ("customer/insert")
    suspend fun registerCustomer(
            @Body customer:Customer)
    :Response<LoginResponse>

    // Login Customer
    @POST ("customer/login")
    suspend fun checkUser(
            @Field ("email") email: String? = null,
            @Field ("password") password: String? = null
    ): Response<LoginResponse>
}