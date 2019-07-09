package com.example.afiyahospital.data

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface RoleDao {
    @Query("SELECT * from role ORDER BY role ASC")
    fun getAllCard(): LiveData<List<Role>>

    @Query("SELECT * FROM role Where role=:role")
    fun getCardByNo(role : String): LiveData<Role>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertHospital(role: String):Long

    @Update
    fun update(role: String):Int

    @Query("Delete from role where id =:rno")
    fun deleteHospital(rno:Long):Int

}