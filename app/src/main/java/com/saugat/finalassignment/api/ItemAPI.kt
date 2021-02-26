package com.saugat.finalassignment.api

import com.saugat.finalassignment.entity.Item
import com.saugat.finalassignment.response.AddItemResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface ItemAPI {

    @POST ("/add/item")
    suspend fun addItem(
        @Header ("Authorization") token: String,
        @Body item: Item
    ):Response<AddItemResponse>
}