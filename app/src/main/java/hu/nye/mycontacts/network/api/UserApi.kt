package hu.nye.mycontacts.network.api

import hu.nye.mycontacts.entity.User
import hu.nye.mycontacts.network.response.UserListResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface UserApi {

    @GET(".")
    fun getUsers(@Query("results") resultsValue : Int) : Single<UserListResponse>
}