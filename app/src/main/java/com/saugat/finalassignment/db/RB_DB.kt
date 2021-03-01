package com.saugat.finalassignment.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.saugat.finalassignment.dao.UserDAO
import com.saugat.finalassignment.entity.User
import com.saugat.finalassignment.entity.UserLocal

@Database(
        entities = [(UserLocal::class)],
        version = 2,
        exportSchema = false
)

abstract class RB_DB: RoomDatabase() {

    abstract fun getUserDAO(): UserDAO

    companion object {
        @Volatile
        private var instance: RB_DB? = null

        fun getInstance(context: Context): RB_DB {
            if (instance == null) {
                synchronized(RB_DB::class) {
                    instance = buildDatabase(context)
                }
            }
            return instance!!
        }

        private fun buildDatabase(context: Context) =
                Room.databaseBuilder(
                        context.applicationContext,
                        RB_DB::class.java,
                        "StudentDB"

                )
                        .fallbackToDestructiveMigration()
                        .build()
    }
}