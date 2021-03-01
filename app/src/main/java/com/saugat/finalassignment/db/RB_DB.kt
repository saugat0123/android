package com.saugat.finalassignment.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.saugat.finalassignment.entity.User

@Database(
        entities = [(User::class), (User::class)],
        version = 2,
        exportSchema = false
)

abstract class RB_DB: RoomDatabase() {
}