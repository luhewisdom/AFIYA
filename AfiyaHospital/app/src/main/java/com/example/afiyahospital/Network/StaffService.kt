package com.example.afiyahospital.network

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
import retrofit2.http.*
import java.util.concurrent.TimeUnit

interface StaffService {

    @POST("staff/registerHospital")
    fun  registerHospital(@Body hospital: Hospital) : Deferred<Response<NetworkHospital>>


    @GET("staff/appoint/myappoints/one/{cno}")
    fun getOneAppoint(@Path("cno")cno:String,@Header("Authorization") token:String): Deferred<Response<NetworkCard>>

    @GET("staff/appointments")
    fun getHospitalAppointment(@Header("Authorization") token:String): Deferred<Response<NetworkCard>>

    @PATCH("staff/approve/{id}")
    fun  updateAppointment(@Path("id")id:Long,
                           @Path("approve")approve:Boolean,
                           @Path("desc")desc:String):Deferred<Response<NetworkCard>>


    @DELETE("staff/appointment/delete")
    fun delteAppointmetnt(@Path("id")id:Long,@Header("Authorization") token:String):Deferred<Response<Void>>

    @GET("staff/appoint/reports/one/{rno}")
    fun getOneReport(@Path("rno") rno:String,@Header("Authorization") token:String): Deferred<Response<NetworkReport>>

    @GET("staff/reports")
    fun getRportForHospital(@Path("hospital")hname:String,@Header("Authorization") token:String):Deferred<Response<List<NetworkReport>>>

    @POST("staff/report")
    fun postReport(@Body report: NetworkReport, @Path("username")username: String,@Header("Authorization") token:String):Deferred<Response<NetworkReport>>

    @DELETE("staff/deleteHospital/{id}")
    fun deleteHospital(@Path("id") id:Long,@Header("Authorization") token:String):Deferred<Response<Void>>

    companion object {
        fun getInstance(): StaffService {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()
            return retrofit.create(StaffService::class.java)
        }
    }

}