package hu.nye.mycontacts.network.controller

import hu.nye.mycontacts.entity.User
import hu.nye.mycontacts.network.api.UserApi
import hu.nye.mycontacts.network.core.ApiClient
import hu.nye.mycontacts.network.core.HttpClientFactory
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class UserController {

    companion object {
        const val BASE_URL = "https://randomuser.me/api/"
    }

    fun getUsers(requestedUsers : Int) : Single<List<User>> {
        val client = ApiClient.makeHttpClient(HttpClientFactory().getClient(), baseUrl = BASE_URL)
            .create(UserApi::class.java)

        return client.getUsers(requestedUsers)
            .subscribeOn(Schedulers.io())
            .map { response ->
                response.results.map { userResponse ->
                    User(
                        nameId = "${userResponse.name.title} ${userResponse.name.first} ${userResponse.name.last}",
                        emailId = userResponse.email,
                        addressId = userResponse.location.city,
                        imageUrlId = userResponse.picture.large
                    )
                }

            }

    }
}