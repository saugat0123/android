package com.saugat.finalassignment

import com.saugat.finalassignment.models.Item

class ItemData private constructor(){
    var mylist = ArrayList<Item>()

    fun list(): ArrayList<Item>{
        return mylist
    }

    companion object {
        private val data = ItemData()
        fun get(): ItemData {
            return data
        }
    }
}