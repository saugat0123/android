package com.saugat.finalassignment.response

import com.saugat.finalassignment.entity.User

data class LoginResponse(
        val success: Boolean? = null,
        val token: String? = null,
        val data: User? = null
)

