package com.saugat.finalassignment.response

import com.saugat.finalassignment.entity.User

data class GetMeResponse (
        val success: Boolean? = null,
        val data: MutableList<User>? = null
)