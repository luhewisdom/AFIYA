package com.example.loginpage.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.afiyahospital.data.Role
import java.io.Serializable

@Entity(foreignKeys = arrayOf(
    ForeignKey(entity = Role::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("role"),
        onDelete = ForeignKey.NO_ACTION)
))
data class User(
    val username:String,
    val password:String,
    val name:String,
    val lname:String,
    val email:String,
    val phone:String,
    val role:String) :Serializable{
    @PrimaryKey(autoGenerate = true) var id:Long =0
}