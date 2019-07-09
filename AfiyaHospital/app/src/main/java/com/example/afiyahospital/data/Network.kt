package com.example.afiyahospital.data

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

abstract class Network {


    companion object {
        private val baseUrl = "http://10.0.2.2:8080/"
        fun getInstance(): HospitalService {
            val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()
            return retrofit.create(HospitalService::class.java)
        }
    }
}