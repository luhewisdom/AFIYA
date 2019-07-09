package com.example.afiyahospital.data

import com.example.loginpage.data.User
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface LoginService {


    @GET("/access-denied")
    fun accessDenied(): Deferred<Response<String>>

    @POST("/login/{username/{password}}")
    fun getLogin(@Path("username") username:String, @Path("password") password:String): Deferred<Response<LoginResponse>>

    @POST("/registerClient")
    fun registerClient(@Body user:User)
}