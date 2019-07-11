package com.example.afiyahospital.repository

import androidx.lifecycle.LiveData
import com.example.afiyahospital.data.Hospital
import com.example.afiyahospital.network.HospitalService
import com.example.afiyahospital.network.asDatabaseModel
import com.example.loginpage.data.HospitalDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.ConnectException

class HospitalRepository  constructor(private val hospitalDao: HospitalDao,private val  hospitalService:HospitalService) {
    suspend fun refershHospital()=
        withContext(Dispatchers.IO){
            val hospitals =hospitalService.getAllHospitals().await().body()

            if (hospitals != null) {
                hospitalDao.insertAll(hospitals.asDatabaseModel())
            }
        }

    //val allHospitals : LiveData<List<Hospital>> = hospitalDao.getAllHospital()

    suspend fun refreshOneHospital(id:Long)=
        withContext(Dispatchers.IO){
            val oneHospital = hospitalService.getOneHospital(id).await().body()
            if (oneHospital != null) {
                hospitalDao.insertHospital(oneHospital.asDatabaseModel())
            }
            return@withContext hospitalDao.getHospital(id)
        }

    suspend fun refereshHospitals()=
        withContext(Dispatchers.IO){
            try {
                val hospitals =hospitalService.getHospitals().await()
                if (hospitals !=null)
                {
                    hospitalDao.insertAll(hospials = hospitals.asDatabaseModel())
                }
                return@withContext hospitalDao.getAllHospital()
            }
            catch (e:ConnectException)
            {
                return@withContext hospitalDao.getAllHospital()
            }
            return@withContext hospitalDao.getAllHospital()
        }


    ////////////////////////////////////////////////
    fun allHospital(): LiveData<List<Hospital>> = hospitalDao.getAllHospital()

    fun oneHospital(id:Long): LiveData<Hospital> {
        return hospitalDao.getHospital(id)
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