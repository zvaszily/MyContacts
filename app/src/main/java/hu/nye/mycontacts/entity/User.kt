package hu.nye.mycontacts.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val nameId: String,
    val emailId: String,
    val workPhoneNumber: String,
    val privatePhoneNumber: String,
    val addressId: String,
    val imageUrlId: String
    ) : Parcelable