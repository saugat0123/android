package com.saugat.finalassignment

import com.saugat.finalassignment.models.ItemMenu

class ItemData private constructor(){
    var mylist = ArrayList<ItemMenu>()

    fun list(): ArrayList<ItemMenu>{
        return mylist
    }

    companion object {
        private val data = ItemData()
        fun get(): ItemData {
            return data
        }
    }
}