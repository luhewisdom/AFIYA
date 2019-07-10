package com.example.afiyahospital.network

import com.example.afiyahospital.data.Card
import com.squareup.moshi.JsonClass
import java.util.*

@JsonClass(generateAdapter = true)
data class NetworkCard(
    val id:Long,
    val cardNo:String,
    val description:String,
    val date : Date,
    val approved:Boolean,
    val userName:String,
    val hospitalName:String
)

fun NetworkCard.asDatabaseModel(): Card {
    return Card(id = id,cardNo = cardNo,description = description,date = date,
        approved = approved,userName = userName,hospitalName = hospitalName)
}
