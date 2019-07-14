package com.example.afiyahospital.network

import com.example.afiyahospital.Utilits.API_CONNECT_TIMEOUT
import com.example.afiyahospital.Utilits.API_READ_TIMEOUT
import com.example.afiyahospital.Utilits.BASE_URL
import com.example.afiyahospital.data.Card
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.*
import java.util.concurrent.TimeUnit

interface CardService {


    @GET("appoint/myappoints")
    fun getAllAppoint(@Header("Authorization") token:String): Deferred<Response<List<NetworkCard>>>

    @GET("appoint/myappoints/one/{cno}")
    fun getOneAppoint(@Path("cno")cno:String,@Header("Authorization") token:String): Deferred<Response<NetworkCard>>



     ///////////////
    @GET("appoint/reports")
    fun getReports(@Header("Authorization") token:String): Deferred<Response<List<NetworkReport>>>

    @GET("appoint/reports/one/{rno}")
    fun getOneReport(@Path("rno") rno:String,@Header("Authorization") token:String): Deferred<Response<NetworkReport>>


    @POST("appoint/{hospital}")
    fun  setAppoiintment(@Body card: Card, @Path("hospital")hospital:String,@Header("Authorization") token:String) :Deferred<Response<NetworkCard>>


    companion object {
        private val moshiBuilder = Moshi.Builder().add(MoshiDateAdapter())
        val client = OkHttpClient
            .Builder()
            .build()
        fun getInstance(): CardService {
            val client = OkHttpClient
                .Builder()
                .build()
            val retrofit = Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080/")

                .addConverterFactory(MoshiConverterFactory.create(moshiBuilder.build()))
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()
            return retrofit.create(CardService::class.java)
        }
    }
}