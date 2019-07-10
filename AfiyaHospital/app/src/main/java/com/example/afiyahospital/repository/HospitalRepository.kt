package com.example.afiyahospital.repository

import androidx.lifecycle.LiveData
import com.example.afiyahospital.data.Hospital
import com.example.afiyahospital.Network.HospitalService
import com.example.loginpage.data.HospitalDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class HospitalRepository(private val hospitalService: HospitalService,
                         private val hospitalDao: HospitalDao) {
    suspend fun getAllHospitals():Response<List<Hospital>> =
        withContext(Dispatchers.IO)
        {
            hospitalService.getAllHospitals().await()
        }
    suspend fun getOneHospital(id:Long):Response<Hospital> =
        withContext(Dispatchers.IO)
        {
           hospitalService.getOneHospital(id).await()
        }
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
}