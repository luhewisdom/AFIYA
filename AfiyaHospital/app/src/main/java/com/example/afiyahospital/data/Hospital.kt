package com.example.loginpage.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "hospital")
data class Hospital(val name:String,
                    val phoneNumber:String,
                    val adress:String,
                    val hospitalIcon:String):Serializable {
    @PrimaryKey(autoGenerate = true) var id:Long = 0

}