package com.example.afiyahospital.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface CardDao {

    @Query("SELECT * from card ORDER BY cardNo ASC")
    fun getAllCard(): LiveData<List<Card>>

    @Query("SELECT * FROM card Where cardNo =:cardno")
    fun getCardByNo(cardno :String): LiveData<Card>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertHospital(card:Card):Long

    @Update
    fun update(card:Card):Int

    @Delete
    fun deleteHospital(card:Card):Int
}