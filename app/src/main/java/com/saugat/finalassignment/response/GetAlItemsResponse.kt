package com.saugat.finalassignment.response

import com.saugat.finalassignment.entity.Item

data class GetAlItemsResponse (
        val success: Boolean? = null,
        val data: MutableList<Item>? = null
)