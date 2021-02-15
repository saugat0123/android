package com.saugat.finalassignment.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

//@Entity
data class User (
        var firstName : String? = null,
        var lastName : String? = null,
        var password : String? = null,
        var address : String? = null,
        var phone : String? = null,
        var email : String? = null,
        )
//{
//    @PrimaryKey(autoGenerate = true)
//    var customerId: Int = 0
//}