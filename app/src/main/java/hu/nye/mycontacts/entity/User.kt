package hu.nye.mycontacts.entity

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class User(
    @StringRes val nameId: String,
    @StringRes val emailId: String,
    @StringRes val addressId: String,
    @DrawableRes val imageUrlId: Int
                ){
}