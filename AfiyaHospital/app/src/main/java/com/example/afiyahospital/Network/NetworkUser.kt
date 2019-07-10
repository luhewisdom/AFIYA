package com.example.afiyahospital.Network

import com.example.afiyahospital.data.Card
import com.example.loginpage.data.User
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkUser(
    val id:Long,
    val username:String,
    val password:String,
    val name:String,
    val lname:String,
    val email:String,
    val phone:String,
    val role:String)

fun NetworkUser.asDatabaseModel(): User {
    return User(username = username,password = password,name = name,lname = lname,
        email = email,phone = phone,role = role)
}


