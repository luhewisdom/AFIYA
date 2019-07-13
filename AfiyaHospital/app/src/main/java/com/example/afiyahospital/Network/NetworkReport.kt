package com.example.afiyahospital.network

import com.example.afiyahospital.data.Report
import com.squareup.moshi.JsonClass
import java.util.*


data class NetworkReport(
    val id:Long,
    val reportNo:String,
    val bloodTesst:String,
    val urinTest: String,
    val otherTest:String,
    val reportDate: Date,
    val user :String,
    val hospital :String
)

fun NetworkReport.asDatabaseModel():Report {
    return Report(id = id, reportDate = reportDate,bloodTesst = bloodTesst,urinTest = urinTest
    ,otherTest = otherTest,reportNo = reportNo,user = user,hospital = hospital)
}

