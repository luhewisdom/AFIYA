package com.example.afiyahospital.repository

import androidx.lifecycle.LiveData
import com.example.afiyahospital.data.Hospital
import com.example.afiyahospital.network.HospitalService
import com.example.afiyahospital.network.asDatabaseModel
import com.example.loginpage.data.HospitalDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HospitalRepository(private val hospitalDao: HospitalDao) {
    lateinit var  hospitalService:HospitalService
    suspend fun refershHospital(){
        withContext(Dispatchers.IO){

            val hospitals =hospitalService.getAllHospitals().await()

            hospitalDao.insertAll(hospitals.asDatabaseModel())
        }
    }
    val allHospitals : LiveData<List<Hospital>> = hospitalDao.getAllHospital()

    suspend fun refreshOneHospital(id:Long){
        withContext(Dispatchers.IO){
            val oneHospital = hospitalService.getOneHospital(id).await()
            hospitalDao.insertHospital(oneHospital.asDatabaseModel())
        }
    }
    suspend fun refereshHospitals(){
        withContext(Dispatchers.IO){

            val hospitals =hospitalService.getHospitals().await()

            hospitalDao.insertAll(hospitals.asDatabaseModel())
        }
    }

    ////////////////////////////////////////////////
    fun allHospital(): LiveData<List<Hospital>> = hospitalDao.getAllHospital()

    fun oneHospital(hname:String): LiveData<Hospital> {
        return hospitalDao.getHospital(hname)
    }
    fun insertHospital(hospital: Hospital):Long{
        return hospitalDao.insertHospital(hospital)
    }

    fun updateHospital(hospital: Hospital):Int
    {
        return hospitalDao.update(hospital)
    }
    fun deleteHospital(hospital: Hospital):Int{

        return hospitalDao.deleteHospital(hospital)
    }
    /////////////////////////////////////////////////////
}