package com.saugat.rblibrary.entity

import android.os.Parcel
import android.os.Parcelable

data class Cart(
        var _id: String? = null,
        val itemName: String? = null,
        val photo: String? = null,
        val quantity: String? = null,
        val itemPrice: Int? = null
): Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readValue(Int::class.java.classLoader) as? Int) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(_id)
        parcel.writeString(itemName)
        parcel.writeString(photo)
        parcel.writeString(quantity)
        parcel.writeValue(itemPrice)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Cart> {
        override fun createFromParcel(parcel: Parcel): Cart {
            return Cart(parcel)
        }

        override fun newArray(size: Int): Array<Cart?> {
            return arrayOfNulls(size)
        }
    }
}