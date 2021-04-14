package com.saugat.rblibrary.response

import com.saugat.finalassignment.entity.User

data class UpdateUserResponse(
        val success: Boolean? = null,
        val data: User? = null
)

