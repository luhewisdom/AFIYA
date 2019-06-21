package com.example.afiyahospital.data

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface HospitalApiService {
    @GET("hospital/hospitals")
    fun getAllHospitals():Deferred<Response<List<HospitalApiData>>>

    @GET("hospital/hospitals/{id}")
    fun getOneHospital(@Path("id") id:Long):Deferred<Response<HospitalApiData>>


    companion object {
        private val baseUrl = "http://10.0.2.2:8080/"
        fun getInstance(): HospitalApiService {


            val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()
            return retrofit.create(HospitalApiService::class.java)
         }
    }
}