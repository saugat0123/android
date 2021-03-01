package com.saugat.finalassignment.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.saugat.finalassignment.entity.User
import com.saugat.finalassignment.entity.UserLocal

@Dao
interface UserDAO {

    @Insert
    suspend fun registerUser(userLocal: UserLocal)

    @Query("SELECT * FROM UserLocal where email=(:email)")
    suspend fun getUser(email: String) : UserLocal
}