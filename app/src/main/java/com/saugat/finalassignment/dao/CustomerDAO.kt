package com.saugat.finalassignment.dao

import androidx.room.*
import com.saugat.finalassignment.entity.Customer

@Dao
interface CustomerDAO {
    @Insert
    suspend fun registerCustomer(customer:Customer)

    @Query("select * from Customer where customerEmail=(:email) and customerPassword=(:password)")
    suspend fun checkCustomer(email: String, password: String): Customer

//    @Update
//    suspend fun updateCustomer(customer:Customer)
//
//    @Delete
//    suspend fun deleteCustomer(customer:Customer)
}