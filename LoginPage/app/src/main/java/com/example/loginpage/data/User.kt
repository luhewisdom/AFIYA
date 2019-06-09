package com.example.loginpage.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class User(
    val userName:String,
    val email:String,
    val password:String) :Serializable{

    @PrimaryKey(autoGenerate = true) var id:Long =0

}