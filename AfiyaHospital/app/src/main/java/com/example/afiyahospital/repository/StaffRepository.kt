package com.example.afiyahospital.repository

import androidx.lifecycle.LiveData
import com.example.afiyahospital.Utilits.InjectorUtils
import com.example.afiyahospital.data.Card
import com.example.afiyahospital.data.CardDao
import com.example.afiyahospital.data.Hospital
import com.example.afiyahospital.network.*
import com.example.loginpage.data.HospitalDao
import com.example.loginpage.data.User
import com.example.loginpage.data.UserDao
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.ConnectException


class   StaffRepository constructor(private val cardDao: CardDao, private val  staffService: StaffService,private val hospitalService: HospitalService,private val hospitalDao: HospitalDao) {
    private val gsonBuilder: Gson = InjectorUtils.provideGson()


    suspend fun registerSHospital(h: NetworkHospital,token:String) : LiveData<Hospital> =
        withContext(Dispatchers.IO)
    {
       val hospitalNetwork =  staffService.registerHospital(token
           ,h.hname
           ,h.owendby
           ,h.phoneNumbe
           ,h.image,
           h.relativeAdress,
           h.longtuide,
           h.latitude).await().body()


            val hospital = hospitalDao.insertHospital(hospitalNetwork!!.asDatabaseModel())


        hospitalDao.getHospital(hospital)
    }

    suspend fun gethospitalAppointment(token: String):LiveData<List<Card>> =
        withContext(Dispatchers.IO){
           val cards =  staffService.getHospitalAppointment(token).await().body() as List<Card>
            cardDao.insertAll(cards)
            return@withContext cardDao.getAllCard()
        }
    suspend fun updaatAppointment(id:Long , approve:Boolean ,desc:String,token: String) =
        withContext(Dispatchers.IO){
            val card =  staffService.updateAppointment(id,approve,desc,token) as Card
            cardDao.update(card)
        }

}