package com.saugat.finalassignment.repository

import com.saugat.finalassignment.api.CustomerAPI
import com.saugat.finalassignment.api.MyApiRequest
import com.saugat.finalassignment.api.ServiceBuilder
import com.saugat.finalassignment.entity.Customer
import com.saugat.finalassignment.response.LoginResponse

class CustomerRepo : MyApiRequest() {
    private val customerAPI= ServiceBuilder.buildService(CustomerAPI::class.java)

    //Register Customer
    suspend fun registerCustomer(customer: Customer): LoginResponse{
        return apiRequest {
            customerAPI.registerCustomer(customer)
        }
    }

    //Login Customer
    suspend fun loginCustomer(email: String, password: String): LoginResponse{
        return apiRequest {
            customerAPI.checkUser(email,password)
        }
    }
}