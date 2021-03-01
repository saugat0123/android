package com.saugat.finalassignment.dao

import androidx.room.Dao
import androidx.room.Query
import com.saugat.finalassignment.entity.User

@Dao
interface UserDAO {

    @Query("SELECT * FROM User")
    suspend fun getAllStudents() : List<User>
}