package com.example.afiyahospital.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.util.*


@Entity(tableName = "card")
data class Card(
    @PrimaryKey(autoGenerate = true)val id:Long,
    val cardNo:String,
    val description:String,
    val date : Date,
    val approved:Boolean,
    val userName:String,
    val hospitalName:String
): Serializable {

}