package com.saugat.finalassignment.repository

import com.saugat.finalassignment.api.ItemAPI
import com.saugat.finalassignment.api.MyApiRequest
import com.saugat.finalassignment.api.ServiceBuilder
import com.saugat.finalassignment.entity.Item
import com.saugat.finalassignment.response.AddItemResponse
import com.saugat.finalassignment.response.GetAlItemsResponse
import com.saugat.finalassignment.response.ImageResponse
import okhttp3.MultipartBody


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

    suspend fun getDrinks(): GetAlItemsResponse{
        return apiRequest {
            itemAPI.getDrinks(ServiceBuilder.token!!)
        }
    }

    suspend fun getVege(): GetAlItemsResponse{
        return apiRequest {
            itemAPI.getVege(ServiceBuilder.token!!)
        }
    }

    suspend fun getNonVege(): GetAlItemsResponse{
        return apiRequest {
            itemAPI.getNonVege(ServiceBuilder.token!!)
        }
    }

    suspend fun uploadImage(id: String, body: MultipartBody.Part)
            : ImageResponse {
        return apiRequest {
            itemAPI.uploadImage(ServiceBuilder.token!!, id, body)
        }
    }
}