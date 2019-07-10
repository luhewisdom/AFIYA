package com.example.afiyahospital.data

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface RoleDao {
    @Query("SELECT * from role ORDER BY role ASC")
    fun getAllCard(): LiveData<List<Role>>

    @Query("SELECT * FROM role Where role=:ro")
    fun getCardByNo(ro : String): LiveData<Role>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertHospital(role: Role):Long

    @Update
    fun update(role: Role):Int

    @Query("Delete from role where id =:rno")
    fun deleteHospital(rno:Long):Int

}