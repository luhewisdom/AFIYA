package com.example.afiyahospital.network

import com.example.afiyahospital.Utilits.API_CONNECT_TIMEOUT
import com.example.afiyahospital.Utilits.API_READ_TIMEOUT
import com.example.afiyahospital.Utilits.BASE_URL
import com.example.loginpage.data.User
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.*
import java.util.concurrent.TimeUnit

interface UserService {

    @GET("/user/users")
    fun getAllUsers(): Deferred<Response<List<User>>>

    @GET("/user/users/{username}")
    fun getOneUser(@Path("username") username:String,@Header("Authorization") token:String): Deferred<Response<NetworkUser>>

    @POST("/user/staaff/register")
    fun registerHospital(@Body user:NetworkUser,@Path("level")level:String,@Header("Authorization") token:String):Deferred<Response<NetworkUser>>

    @POST("/user/staaff/register/role")
    fun registerRole(@Body role: NetworkRole,@Header("Authorization") token:String):Deferred<Response<Void>>



    companion object {
        fun getInstance(): UserService {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()
            return retrofit.create(UserService::class.java)
        }
    }
}