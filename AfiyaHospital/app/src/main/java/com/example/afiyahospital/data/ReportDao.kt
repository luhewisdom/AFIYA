package com.example.afiyahospital.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ReportDao {
    @Query("SELECT * from report ORDER BY reportNo ASC")
    fun getAllReport(): LiveData<List<Report>>

    @Query("SELECT * FROM report Where reportNo =:rno")
    fun getReportByNo(rno :String): LiveData<Report>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertReport(report: Report):Long
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll( reports: List<Report>)
    @Update
    fun update(report: Report):Int

    @Query("Delete from report where reportNo =:rno")
    fun deleteHospital(rno:String):Int
}