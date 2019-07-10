package com.example.afiyahospital.Network

import com.example.afiyahospital.data.Card
import com.example.afiyahospital.data.Role
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkRole(val id:Long ,
                       val role:String )
fun NetworkRole.asDatabaseModel(): Role {
    return Role(id = id,role = role)
}