package com.saugat.finalassignment.response

import com.saugat.finalassignment.entity.Item

data class AddItemResponse (
    val success: Boolean? = null,
    val data: Item? = null
        ) {

}