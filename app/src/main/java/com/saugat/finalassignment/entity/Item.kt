package com.saugat.finalassignment.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


data class Item (
    var _id: String? = null,
    val itemName: String? = null,
    val itemType: String? = null,
    val itemRating: String? = null,
    val itemPrice: Int? = null
)
