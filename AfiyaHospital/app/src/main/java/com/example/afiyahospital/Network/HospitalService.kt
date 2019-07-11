package com.example.afiyahospital.network

import com.example.afiyahospital.Utilits.API_CONNECT_TIMEOUT
import com.example.afiyahospital.Utilits.API_READ_TIMEOUT
import com.example.afiyahospital.Utilits.BASE_URL
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.concurrent.TimeUnit

interface HospitalService {
    @GET("")
    fun getHospitals():Deferred<NetworkHospitals>

    @GET("hospital/hospitals")
    fun getAllHospitals():Deferred<Response<NetworkHospitals>>

    @GET("hospital/hospitals/{id}")
    fun getOneHospital(@Path("id") id:Long):Deferred<Response<NetworkHospital>>


    companion object {
        fun getInstance(): HospitalService {
            val client = OkHttpClient
                .Builder()
                .build()
            val retrofit = Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080/")
                .client(client)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()
            return retrofit.create(HospitalService::class.java)
        }
    }

}