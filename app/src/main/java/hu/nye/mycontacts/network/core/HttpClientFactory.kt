package hu.nye.mycontacts.network.core

import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

class HttpClientFactory {

    fun getClient() : OkHttpClient {
        return OkHttpClient.Builder()
            .writeTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .connectTimeout(5,TimeUnit.SECONDS)
            .build()
    }
}