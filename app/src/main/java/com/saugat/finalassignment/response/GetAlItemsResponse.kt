package com.saugat.finalassignment.response

import com.saugat.finalassignment.entity.Item

data class GetAlItemsResponse (
        val success: Boolean? = null,
        val count: Int? = null,
        val data: MutableList<Item>? = null
)