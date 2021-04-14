package com.saugat.rblibrary.repository

import com.saugat.rblibrary.api.CartAPI
import com.saugat.rblibrary.api.MyApiRequest
import com.saugat.rblibrary.api.ServiceBuilder
import com.saugat.rblibrary.entity.Cart
import com.saugat.rblibrary.response.AddItemResponse
import com.saugat.rblibrary.response.DeleteCartResponse
import com.saugat.rblibrary.response.GetAlItemsResponse

class CartRepo: MyApiRequest() {

    private val cartAPI= ServiceBuilder.buildService(CartAPI::class.java)

    suspend fun addItemToCart(cart: Cart): AddItemResponse {
        return apiRequest {
            cartAPI.addItemToCart(
                    ServiceBuilder.token!!, cart
            )
        }
    }

    suspend fun getCartItems(): GetAlItemsResponse {
        return apiRequest {
            cartAPI.getCartItems(ServiceBuilder.token!!)
        }
    }

    suspend fun  deleteCartItem(id: String): DeleteCartResponse{
        return apiRequest {
            cartAPI.deleteCartItem(ServiceBuilder.token!!,id)
        }
    }
}