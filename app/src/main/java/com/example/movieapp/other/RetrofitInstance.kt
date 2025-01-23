package com.example.movieapp.other

import com.example.movieapp.interfaces.ApiService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL ="https://api.jikan.moe/v4/"

    private fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    val apiService: ApiService = getInstance().create(ApiService::class.java)
}

private val client: OkHttpClient
    get() {
        val builder = getHttpClientBuilder()
        builder.addInterceptor(Interceptor { chain ->
            val request: Request = chain.request()
                .newBuilder()
                .header("accept", "application/json")
                .build()
            chain.proceed(request)
        })
        return builder.build()
    }

private fun getHttpClientBuilder(): OkHttpClient.Builder {
    val builder = OkHttpClient.Builder()
    return builder
}