package com.example.afiyahospital.repository

import androidx.lifecycle.LiveData
import com.example.afiyahospital.data.Card
import com.example.afiyahospital.data.CardDao
import com.example.afiyahospital.data.Hospital
import com.example.afiyahospital.network.CardService
import com.example.afiyahospital.network.HospitalService
import com.example.afiyahospital.network.StaffService
import com.example.loginpage.data.HospitalDao
import com.example.loginpage.data.User
import com.example.loginpage.data.UserDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.ConnectException


class   StaffRepository constructor(private val cardDao: CardDao, private val  staffService: StaffService,private val hospitalService: HospitalService,private val hospitalDao: HospitalDao) {


    suspend fun registerStaff(hospital: Hospital,token:String) : LiveData<Hospital> = withContext(Dispatchers.IO)
    {
       val hospital =  staffService.registerHospital(hospital,token).await() as  Hospital
        hospitalDao.insertHospital(hospital)
        hospitalDao.getHospital(hospital.id)
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