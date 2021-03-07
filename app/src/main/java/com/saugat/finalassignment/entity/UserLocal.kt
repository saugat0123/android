package com.saugat.finalassignment.entity

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserLocal (
        var firstName : String? = null,
        var lastName : String? = null,
        var password : String? = null,
        var address : String? = null,
        var phone : String? = null,
        var email : String? = null,
        ) : Parcelable {
        @PrimaryKey(autoGenerate = true)
        var userId: Int = 0

        constructor(parcel: Parcel) : this(
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString()) {
                userId = parcel.readInt()
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
                parcel.writeString(firstName)
                parcel.writeString(lastName)
                parcel.writeString(password)
                parcel.writeString(address)
                parcel.writeString(phone)
                parcel.writeString(email)
                parcel.writeInt(userId)
        }

        override fun describeContents(): Int {
                return 0
        }

        companion object CREATOR : Parcelable.Creator<UserLocal> {
                override fun createFromParcel(parcel: Parcel): UserLocal {
                        return UserLocal(parcel)
                }

                override fun newArray(size: Int): Array<UserLocal?> {
                        return arrayOfNulls(size)
                }
        }
}