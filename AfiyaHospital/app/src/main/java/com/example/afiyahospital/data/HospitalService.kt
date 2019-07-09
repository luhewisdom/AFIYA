package com.example.afiyahospital.data

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface HospitalService {
    @GET
    fun getHospitals():Deferred<Response<List<Hospital>>>

    @GET("hospital/hospitals")
    fun getAllHospitals():Deferred<Response<List<Hospital>>>

    @GET("hospital/hospitals/{id}")
    fun getOneHospital(@Path("id") id:Long):Deferred<Response<Hospital>>


}