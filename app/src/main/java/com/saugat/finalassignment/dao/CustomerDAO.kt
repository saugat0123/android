package com.saugat.finalassignment.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import com.saugat.finalassignment.entity.Customer

@Dao
interface CustomerDAO {
    @Insert
    suspend fun registerCustomer(customer:Customer)

    @Update
    suspend fun updateCustomer(customer:Customer)

    @Delete
    suspend fun deleteCustomer(customer:Customer)
}