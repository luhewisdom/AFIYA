package com.example.afiyahospital.data

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface RoleDao {
    @Query("SELECT * from role ORDER BY role ASC")
    fun getAllRole(): LiveData<List<Role>>

    @Query("SELECT * FROM role Where role=:ro")
    fun getRoleByNo(ro : String): LiveData<Role>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRole(role: Role):Long

    @Update
    fun update(role: Role):Int

    @Query("Delete from role where id =:rno")
    fun deleteReport(rno:Long):Int

}