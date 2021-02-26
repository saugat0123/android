package com.saugat.finalassignment.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


data class Item (
    val itemName: String? = null,
    val itemType: String? = null,
    val itemRating: Float? = null,
    val itemPrice: Int? = null
)
