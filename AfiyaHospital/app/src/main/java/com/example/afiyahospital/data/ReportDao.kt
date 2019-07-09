package com.example.afiyahospital.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ReportDao {
    @Query("SELECT * from report ORDER BY reportNo ASC")
    fun getAllCard(): LiveData<List<Report>>

    @Query("SELECT * FROM report Where reportNo =:rno")
    fun getCardByNo(rno : Long): LiveData<Report>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertHospital(report: Report):Long

    @Update
    fun update(report: Report):Int

    @Query("Delete from report where reportNo =:rno")
    fun deleteHospital(rno:Long):Int
}