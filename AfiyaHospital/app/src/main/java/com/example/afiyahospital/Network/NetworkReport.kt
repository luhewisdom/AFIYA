package com.example.afiyahospital.Network

import com.squareup.moshi.JsonClass
import java.util.*

@JsonClass(generateAdapter = true)
data class NetworkReport(
    val id:Long,
    val reportNo:String,
    val bloodTesst:String,
    val urinTest: String,
    val otherTest:String,
    val reportDate: Date,
    val user :String,
    val hospital :String
)