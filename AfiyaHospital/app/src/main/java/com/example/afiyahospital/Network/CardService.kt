package com.example.afiyahospital.Network

import com.example.afiyahospital.Utilits.API_CONNECT_TIMEOUT
import com.example.afiyahospital.Utilits.API_READ_TIMEOUT
import com.example.afiyahospital.Utilits.BASE_URL
import com.example.afiyahospital.data.Card
import com.example.afiyahospital.data.Report
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import java.util.concurrent.TimeUnit

interface CardService {


    @GET("/appoint/myappoints")
    fun getAllAppoint(): Deferred<Response<List<NetworkCard>>>

    @GET("/appoint/myappoints/one/{cno}")
    fun getOneAppoint(@Path("cno")cno:String): Deferred<Response<NetworkCard>>

    @GET("/appoint/reports")
    fun getReports(): Deferred<Response<List<NetworkReport>>>

    @GET("/appoint/reports/one/{rno}")
    fun getOneReport(@Path("rno") rno:String): Deferred<Response<NetworkReport>>


    @POST("/appoint/{hospital}")
    fun  setAppoiintment(@Body card: Card, @Path("hospital")hospital:String) :Deferred<Response<NetworkCard>>


    companion object {
        val client = OkHttpClient
            .Builder()
            .connectTimeout(API_CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(API_READ_TIMEOUT, TimeUnit.SECONDS)
            .build()
        fun getInstance(): CardService {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()
            return retrofit.create(CardService::class.java)
        }
    }
}