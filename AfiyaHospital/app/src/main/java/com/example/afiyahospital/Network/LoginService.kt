package com.example.afiyahospital.Network

import com.example.afiyahospital.Utilits.API_CONNECT_TIMEOUT
import com.example.afiyahospital.Utilits.API_READ_TIMEOUT
import com.example.afiyahospital.Utilits.BASE_URL
import com.example.afiyahospital.data.LoginResponse
import com.example.loginpage.data.User
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import java.util.concurrent.TimeUnit

interface LoginService {


    @GET("/access-denied")
    fun accessDenied(): Deferred<Response<String>>

    @POST("/login/{username/{password}}")
    fun getLogin(@Path("username") username:String, @Path("password") password:String): Deferred<Response<LoginResponse>>

    @POST("/registerClient")
    fun registerClient(@Body user:NetworkUser)


    companion object {
        val client = OkHttpClient
            .Builder()
            .connectTimeout(API_CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(API_READ_TIMEOUT, TimeUnit.SECONDS)
            .build()
        fun getInstance(): LoginService {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()
            return retrofit.create(LoginService::class.java)
        }
    }
}