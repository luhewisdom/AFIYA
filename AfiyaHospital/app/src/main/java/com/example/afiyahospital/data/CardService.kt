package com.example.afiyahospital.data

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface CardService {


    @GET("/appoint/myappoints")
    fun getAllAppoint(): Deferred<Response<List<Card>>>

    @GET("/appoint/myappoints/one/{cno}")
    fun getOneAppoint(@Path("cno")cno:String): Deferred<Response<Card>>

    @GET("/appoint/reports")
    fun getReports(): Deferred<Response<List<Report>>>

    @GET("/appoint/reports/one/{rno}")
    fun getOneReport(@Path("rno") rno:String): Deferred<Response<Report>>


    @POST("/appoint/{hospital}")
    fun  setAppoiintment(@Body card: Card,@Path("hospital")hospital:String) :Deferred<Response<Card>>

}