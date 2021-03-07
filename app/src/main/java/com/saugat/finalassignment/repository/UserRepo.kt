package com.saugat.finalassignment.repository

import com.saugat.finalassignment.api.UserAPI
import com.saugat.finalassignment.api.MyApiRequest
import com.saugat.finalassignment.api.ServiceBuilder
import com.saugat.finalassignment.entity.User
import com.saugat.finalassignment.response.GetAlItemsResponse
import com.saugat.finalassignment.response.GetUserProfileResponse
import com.saugat.finalassignment.response.LoginResponse

class UserRepo : MyApiRequest() {
    private val customerAPI= ServiceBuilder.buildService(UserAPI::class.java)

    //Register User
    suspend fun registerUser(user: User): LoginResponse{
        return apiRequest {
            customerAPI.registerUser(user)
        }
    }

    //Login User
    suspend fun loginUser(email: String, password: String): LoginResponse{
        return apiRequest {
            customerAPI.checkUser(email,password)
        }
    }

    suspend fun getMe(): GetUserProfileResponse {
        return apiRequest {
            customerAPI.getMe(ServiceBuilder.token!!)
        }
    }
}