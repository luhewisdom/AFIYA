package com.example.loginpage.data

import androidx.room.*
import com.example.afiyahospital.data.Role
import java.io.Serializable

@Entity
data class User(
    @PrimaryKey(autoGenerate = true) val id:Long,
    val username:String,
    val password:String,
    val name:String,
    val lname:String,
    val email:String,
    val phone:String,
    val role:String) :Serializable{

}