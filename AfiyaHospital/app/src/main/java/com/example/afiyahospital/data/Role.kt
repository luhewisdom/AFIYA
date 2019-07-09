package com.example.afiyahospital.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Role(@PrimaryKey(autoGenerate = true) val id:Long ,
                val role:String ): Serializable {
}