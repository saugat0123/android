package com.saugat.finalassignment.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Customer (
        var customerFirstName : String? = null,
        var customerLastName : String? = null,
        var customerPassword : String? = null,
        var customerAddress : String? = null,
        var customerPhone : String? = null,
        var customerEmail : String? = null,
        )
{
    @PrimaryKey(autoGenerate = true)
    val customerId: Int = 0
}