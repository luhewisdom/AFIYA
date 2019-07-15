package com.example.afiyahospital.network

import com.example.afiyahospital.data.Report
import com.squareup.moshi.JsonClass
import java.util.*


data class NetworkReport(
    val id:Long,
    val reportNo:String,
    val bloodTest:String,
    val urinTest: String,
    val otherTest:String,
    val reportDate: String,
    val user :String,
    val hospital :String
)

fun NetworkReport.asDatabaseModel():Report {
    return Report(id = id, reportNo = reportNo,bloodTest = bloodTest,urinTest = urinTest
    ,otherTest = otherTest,reportDate = reportDate,user = user,hospital = hospital)
}

