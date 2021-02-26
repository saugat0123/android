package com.saugat.finalassignment.repository

import com.saugat.finalassignment.api.ItemAPI
import com.saugat.finalassignment.api.MyApiRequest
import com.saugat.finalassignment.api.ServiceBuilder
import com.saugat.finalassignment.entity.Item
import com.saugat.finalassignment.response.AddItemResponse
import com.saugat.finalassignment.response.GetAlItemsResponse


class ItemRepo: MyApiRequest() {
    private val itemAPI= ServiceBuilder.buildService(ItemAPI::class.java)

    suspend fun addItem(item: Item): AddItemResponse{
        return apiRequest {
            itemAPI.addItem(
                    ServiceBuilder.token!!, item
            )
        }
    }

    suspend fun getAllItems(): GetAlItemsResponse{
        return apiRequest {
            itemAPI.getAllItems(ServiceBuilder.token!!)
        }
    }
}