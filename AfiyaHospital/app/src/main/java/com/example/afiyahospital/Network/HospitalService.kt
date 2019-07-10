package com.example.afiyahospital.Network

import com.example.afiyahospital.Utilits.API_CONNECT_TIMEOUT
import com.example.afiyahospital.Utilits.API_READ_TIMEOUT
import com.example.afiyahospital.Utilits.BASE_URL
import com.example.afiyahospital.data.Hospital
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.concurrent.TimeUnit

interface HospitalService {
    @GET("/")
    fun getHospitals():Deferred<Response<List<NetworkHospital>>>

    @GET("hospital/hospitals")
    fun getAllHospitals():Deferred<Response<List<Hospital>>>

    @GET("hospital/hospitals/{id}")
    fun getOneHospital(@Path("id") id:Long):Deferred<Response<NetworkHospital>>


    companion object {
        val client = OkHttpClient
            .Builder()
            .connectTimeout(API_CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(API_READ_TIMEOUT, TimeUnit.SECONDS)
            .build()
        fun getInstance(): HospitalService {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()
            return retrofit.create(HospitalService::class.java)
        }
    }

}