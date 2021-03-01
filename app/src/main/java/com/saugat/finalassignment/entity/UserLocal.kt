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
        )
{
        @PrimaryKey(autoGenerate = true)
        var userId: Int = 0
}