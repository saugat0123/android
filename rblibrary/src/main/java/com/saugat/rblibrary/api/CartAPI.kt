package com.saugat.rblibrary.api

import com.saugat.rblibrary.entity.Cart
import com.saugat.rblibrary.response.AddItemResponse
import com.saugat.rblibrary.response.DeleteCartResponse
import com.saugat.rblibrary.response.GetAlItemsResponse
import retrofit2.Response
import retrofit2.http.*

interface CartAPI {

    @POST("/add/cart")
    suspend fun addItemToCart(
            @Header("Authorization") token: String,
            @Body cart: Cart
    ): Response<AddItemResponse>

    @GET("cart/all")
    suspend fun getCartItems(
            @Header("Authorization") token: String,
    ): Response<GetAlItemsResponse>

    @DELETE("delete/{id}")
    suspend fun deleteCartItem(
            @Header ("Authorization") token: String,
            @Path("id") id: String
    ):Response<DeleteCartResponse>
}