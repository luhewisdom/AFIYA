package com.example.loginpage.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface HospitalDao {

    @Query("SELECT * from hospital ORDER BY name ASC")
    fun getAllHospital(): LiveData<List<Hospital>>

    @Query("SELECT * FROM hospital Where name=:hname")
    fun getHospital(hname:String):LiveData<Hospital>

    @Insert
    fun insertHospital(hospital: Hospital):Long

    @Update
    fun update(hospital: Hospital):Int

    @Delete
    fun deleteHospital(hospital: Hospital):Int


}