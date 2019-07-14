package com.example.afiyahospital.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.afiyahospital.data.Card
import com.example.afiyahospital.data.CardDao
import com.example.afiyahospital.data.Hospital
import com.example.afiyahospital.network.CardService
import com.example.afiyahospital.network.HospitalService
import com.example.afiyahospital.network.asDatabaseModel
import com.example.loginpage.data.HospitalDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.ConnectException



class   CardRepository constructor(private val cardDao: CardDao, private val  cardService: CardService) {


    suspend fun refreshOneCard(cno:String,token:String)=
        withContext(Dispatchers.IO){
            val oneCard = cardService.getOneAppoint(cno,token).await()
                cardDao.insertCard(oneCard as Card)
            return@withContext cardDao.getCardByNo(cno)
        }

    suspend fun refereshCard(token: String)=
        withContext(Dispatchers.IO){
            try {
                val cards = cardService.getAllAppoint(token).await().body()
                Log.v("LLLLLLLLLLLL",cards.toString())
                Log.v("LLLLLLLLLLLL",token)
                if (cards !=null)
                {
                    for (res in cards){

                        var card = Card(res.id,res.cardNo,res.description,res.date,res.approved,res.userName,res.hospitalName)
                        cardDao.insertCard(card)
                    }
                }
                return@withContext cardDao.getAllCardRoom()
            }
            catch (e: ConnectException)
            {
                return@withContext  cardDao.getAllCardRoom()
            }
        }

    ////
    suspend fun setAppointment(card: Card,hname :String,token: String) =
        withContext(Dispatchers.IO){
            val card =cardService.setAppoiintment(card,hname,token).await().body()
            cardDao.insertCard(card!!.asDatabaseModel())
            cardDao.getAllCard()
        }



    ////////////////////////////////////////////////


    fun oneHospital(cno:String): LiveData<Card> {
        return cardDao.getCardByNo(cno)
    }
    fun insertCard(card:Card):Long{
        return cardDao.insertCard(card)
    }

    fun updateCard(card: Card):Int
    {
        return cardDao.update(card)
    }
    fun deleteCard(card: Card):Int{

        return cardDao.deleteCard(card)
    }
    /////////////////////////////////////////////////////
}