package com.example.afiyahospital.repository

import com.example.afiyahospital.data.HospitalApiData
import com.example.afiyahospital.data.HospitalApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class HospitalApiRepository(private val hospitalApiService: HospitalApiService) {
    suspend fun getAllHospitals():Response<List<HospitalApiData>> =
        withContext(Dispatchers.IO)
        {
            hospitalApiService.getAllHospitals().await()
        }
    suspend fun getOneHospital(id:Long):Response<HospitalApiData> =
        withContext(Dispatchers.IO)
        {
           hospitalApiService.getOneHospital(id).await()
        }

}