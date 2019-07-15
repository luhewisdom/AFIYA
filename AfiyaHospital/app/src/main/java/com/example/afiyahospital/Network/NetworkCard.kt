package com.example.afiyahospital.network

import com.example.afiyahospital.data.Card
import com.example.afiyahospital.data.Hospital
import com.squareup.moshi.JsonClass
import java.util.*


data class NetworkCard(
    val id:Long,
    val cardNo:String,
    val description:String,
    val date : String,
    val approved:String,
    val userName:String,
    val hospitalName:String
)

fun NetworkCard.asDatabaseModel(): Card {
    return Card(id = id,cardNo = cardNo,description = description,date = date,
        approved = approved,userName = userName,hospitalName = hospitalName)
}