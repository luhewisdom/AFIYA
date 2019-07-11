package com.example.afiyahospital.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "hospital")
data class Hospital(
    @PrimaryKey(autoGenerate = true) val id:Long,
    val hname:String,
    val image:String,
    val owendby:String,
    val phoneNumbe:String,
    val relativeAdress:String,
    val latitude:String,
    val longtuide : String,
    val user:String
): Serializable {
}