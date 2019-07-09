package com.example.afiyahospital.data

import com.example.loginpage.data.User
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface UserService {

    @GET("/user/users")
    fun getAllUsers(): Deferred<Response<List<User>>>

    @GET("/user/users/{username}")
    fun getOneUser(@Path("username") username:String): Deferred<Response<User>>

    @POST("/user/staaff/register")
    fun registerHospital(@Body user:User,@Path("level")level:String):Deferred<Response<User>>

    @POST("/user/staaff/register/role")
    fun registerRole(@Body role:Role):Deferred<Response<Void>>
}