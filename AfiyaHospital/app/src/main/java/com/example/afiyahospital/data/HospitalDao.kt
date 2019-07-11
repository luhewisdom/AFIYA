package com.example.loginpage.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.afiyahospital.data.Hospital

@Dao
interface HospitalDao {

    @Query("SELECT * from hospital ORDER BY hname ASC")
    fun getAllHospital(): LiveData<List<Hospital>>

    @Query("SELECT * FROM hospital Where id =:id")
    fun getHospital(id:Long):LiveData<Hospital>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll( hospials: List<Hospital>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertHospital(hospital: Hospital):Long

    @Update
    fun update(hospital: Hospital):Int

    @Delete
    fun deleteHospital(hospital: Hospital):Int
}