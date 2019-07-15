package com.example.afiyahospital.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.afiyahospital.data.*
import com.example.afiyahospital.network.CardService
import com.example.afiyahospital.network.HospitalService
import com.example.afiyahospital.network.NetworkCard
import com.example.afiyahospital.network.asDatabaseModel
import com.example.loginpage.data.HospitalDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.ConnectException



class   CardRepository constructor(private val cardDao: CardDao,private  val reportDao: ReportDao, private val  cardService: CardService) {


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

    suspend fun setAppointment(c: NetworkCard,token: String):Card =
        withContext(Dispatchers.IO){

            val cardNetwork =  cardService.setAppoiintment(token
                ,c.cardNo,c.description,c.approved,c.hospitalName
            ).await().body()


            cardDao.insertCard(cardNetwork!!.asDatabaseModel())
            cardDao.getCardRoom(c.cardNo)
        }



    suspend fun getAppointments(token: String)=
        withContext(Dispatchers.IO){
            try {
                val reports = cardService.getReports(token).await().body()
                Log.v("LLLLLLLLLLLL",reports.toString())
                Log.v("LLLLLLLLLLLL",token)
                if (reports !=null)
                {
                    for (res in reports){

                        val reportt = Report(id = res.id,reportNo = res.reportNo,reportDate =res.reportDate,bloodTest = res.bloodTest,urinTest =  res.urinTest,otherTest = res.otherTest,
                            hospital = res.hospital,user = res.user)
                        reportDao.insertReport(reportt)

                    }
                }
                return@withContext reportDao.getAllReportRoom()
            }
            catch (e: ConnectException)
            {
                return@withContext reportDao.getAllReportRoom()
            }
            return@withContext reportDao.getAllReportRoom()
        }
    ////

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