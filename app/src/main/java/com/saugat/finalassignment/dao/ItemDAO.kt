package com.saugat.finalassignment.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import com.saugat.finalassignment.entity.Item

@Dao
interface ItemDAO {
    @Insert
    suspend fun registerItem(item: Item)

    @Update
    suspend fun updateItem(item: Item)

    @Delete
    suspend fun deleteItem(item: Item)
}