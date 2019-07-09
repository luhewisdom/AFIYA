package com.example.afiyahospital.data

import androidx.room.Delete
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.*

interface StaffService {

    @POST("/staff/registerHospital")
    fun  registerHospital(@Body hospital: Hospital) : Deferred<Response<Hospital>>


    @GET("staff/appoint/myappoints/one/{cno}")
    fun getOneAppoint(@Path("cno")cno:String): Deferred<Response<Card>>

    @GET("/staff/appointments")
    fun getHospitalAppointment(): Deferred<Response<Card>>

    @PATCH("/staff/approve/{id}")
    fun  updateAppointment(@Path("id")id:Long,
                           @Path("approve")approve:Boolean,
                           @Path("desc")desc:String):Deferred<Response<Card>>


    @DELETE("/staff/appointment/delete")
    fun delteAppointmetnt(@Path("id")id:Long):Deferred<Response<Void>>

    @GET("staff/appoint/reports/one/{rno}")
    fun getOneReport(@Path("rno") rno:String): Deferred<Response<Report>>

    @GET("/staff/reports")
    fun getRportForHospital(@Path("hospital")hname:String):Deferred<Response<List<Report>>>

    @POST("/staff/report")
    fun postReport(@Body report: Report,@Path("username")username: String):Deferred<Response<Report>>

    @DELETE("/staff/deleteHospital/{id}")
    fun deleteHospital(@Path("id") id:Long):Deferred<Response<Void>>

}