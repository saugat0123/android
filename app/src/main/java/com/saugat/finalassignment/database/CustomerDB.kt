package com.saugat.finalassignment.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.saugat.finalassignment.dao.CustomerDAO
import com.saugat.finalassignment.entity.Customer

@Database(
    entities = [(Customer::class)],
    version = 1,
    exportSchema = false
)
abstract class CustomerDB : RoomDatabase() {
    abstract fun getUserDAO(): CustomerDAO
    companion object {
        @Volatile
        private var instance : CustomerDB? = null
        fun getInstance(context : Context) : CustomerDB{
            if(instance == null){
                synchronized(CustomerDB::class){
                    instance = buildDatabase(context)
                }
            }
            return instance!!
        }
        private fun buildDatabase(context : Context) =
            Room.databaseBuilder(
                context.applicationContext,
                CustomerDB::class.java,
                "StudentDB"
            ).build()
    }

}