package com.example.afiyahospital.repository

import com.example.afiyahospital.data.Hospital
import com.example.afiyahospital.data.HospitalService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class HospitalApiRepository(private val hospitalService: HospitalService) {
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

}