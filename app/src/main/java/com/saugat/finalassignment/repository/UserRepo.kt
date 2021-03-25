package com.saugat.finalassignment.repository

import com.saugat.finalassignment.api.UserAPI
import com.saugat.finalassignment.api.MyApiRequest
import com.saugat.finalassignment.api.ServiceBuilder
import com.saugat.finalassignment.entity.User
import com.saugat.finalassignment.response.GetUserProfileResponse
import com.saugat.finalassignment.response.ImageResponse
import com.saugat.finalassignment.response.LoginResponse
import okhttp3.MultipartBody

class UserRepo : MyApiRequest() {
    private val userAPI= ServiceBuilder.buildService(UserAPI::class.java)

    //Register User
    suspend fun registerUser(user: User): LoginResponse{
        return apiRequest {
            userAPI.registerUser(user)
        }
    }

    //Login User
    suspend fun loginUser(email: String, password: String): LoginResponse{
        return apiRequest {
            userAPI.checkUser(email,password)
        }
    }

    suspend fun getMe(): GetUserProfileResponse {
        return apiRequest {
            userAPI.getMe(ServiceBuilder.token!!)
        }
    }

    suspend fun userImageUpload(id: String, body: MultipartBody.Part)
            : ImageResponse {
        return apiRequest {
            userAPI.userImageUpload(ServiceBuilder.token!!, id, body)
        }
    }
}