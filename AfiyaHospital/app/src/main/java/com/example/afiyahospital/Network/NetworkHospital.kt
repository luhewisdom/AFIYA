package com.example.afiyahospital.Network

import androidx.room.PrimaryKey
import com.example.afiyahospital.data.Card
import com.example.afiyahospital.data.Hospital
import com.squareup.moshi.JsonClass
import java.util.*




@JsonClass(generateAdapter = true)
data class NetworkHospital(
    val id:Long,
    val hname:String,
    val image:String,
    val owendby:String,
    val phoneNumbe:String,
    val relativeAdress:String,
    val latitude:String,
    val longtuide : String,
    val user:String
)

fun NetworkHospital.asDatabaseModel(): Hospital {
    return Hospital(id = id, hname = hname,image = image,owendby = owendby,phoneNumbe =phoneNumbe
    ,relativeAdress = relativeAdress,latitude = latitude,longtuide = longtuide,user = user)
}



