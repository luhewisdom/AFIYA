package com.example.afiyahospital.network

import com.example.afiyahospital.data.Role
import com.squareup.moshi.JsonClass

data class NetworkRole(val id:Long ,
                       val role:String )
fun NetworkRole.asDatabaseModel(): Role {
    return Role(id = id,role = role)
}