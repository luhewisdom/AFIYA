package com.example.afiyahospital.repository

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


    suspend fun refreshOneHospital(cno:String,token:String)=
        withContext(Dispatchers.IO){
            val oneCard = cardService.getOneAppoint(cno,token).await()
                cardDao.insertCard(oneCard as Card)
            return@withContext cardDao.getCardByNo(cno)
        }

    suspend fun refereshCard()=
        withContext(Dispatchers.IO){
            try {
                val cards = cardService.getAllAppoint().await().body()
                       cardDao.insertAll(cards = cards as List<Card>)
                return@withContext cardDao.getAllCard()
            }
            catch (e: ConnectException)
            {
                return@withContext  cardDao.getAllCard()
            }
        }
    suspend fun setAppointment(card: Card,hname :String,token: String) =
        withContext(Dispatchers.IO){
            val card =cardService.setAppoiintment(card,hname,token)
            cardDao.insertCard(card as Card)
            cardDao.getAllCard()
        }
    suspend fun getAppointment(token: String) =
        withContext(Dispatchers.IO){
            val cards = cardService.getAllAppoint().await().body() as List<Card>
            cardDao.insertAll(cards)
            cardDao.getAllCard()
        }


    ////////////////////////////////////////////////
    fun allCards(): LiveData<List<Card>> = cardDao.getAllCard()

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