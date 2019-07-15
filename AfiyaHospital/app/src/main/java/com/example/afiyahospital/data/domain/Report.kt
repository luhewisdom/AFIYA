package com.example.afiyahospital.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.util.*

@Entity
data class Report(
    @PrimaryKey val id:Long,
    val reportNo:String,
    val bloodTest:String,
    val urinTest: String,
    val otherTest:String,
    val reportDate: String,
    val user :String,
    val hospital :String
    ): Serializable {
}