package com.example.afiyahospital.data

import androidx.lifecycle.LiveData
import androidx.room.*
import retrofit2.http.Header

@Dao
interface CardDao {

    @Query("SELECT * from card ORDER BY cardNo ASC")
    fun getAllCard(): LiveData<List<Card>>

    @Query("SELECT * from card ORDER BY cardNo ASC")
    fun getAllCardRoom(): List<Card>

    @Query("SELECT * FROM card Where cardNo =:cardno")
    fun getCardByNo(cardno :String): LiveData<Card>

    @Query("SELECT * FROM card Where cardNo =:cardno")
    fun getCardRoom(cardno :String): Card

    @Query("SELECT * FROM card Where cardNo =:cardno")
    fun getCardByNoRoom(cardno :String): Card

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCard(card:Card):Long


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll( cards: List<Card>)
    @Update
    fun update(card:Card):Int

    @Delete
    fun deleteCard(card:Card):Int
}