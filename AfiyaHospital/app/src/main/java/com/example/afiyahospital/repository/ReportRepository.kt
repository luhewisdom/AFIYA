package com.example.afiyahospital.repository


import androidx.lifecycle.LiveData
import com.example.afiyahospital.data.Report
import com.example.afiyahospital.data.ReportDao
import com.example.afiyahospital.network.CardService
import com.example.afiyahospital.network.NetworkReport
import com.example.afiyahospital.network.StaffService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ReportRepository constructor(private val reportDao: ReportDao, private val  staffService: StaffService) {


    suspend fun getReportFromHospital(hname:String ,token:String): LiveData<List<Report>> =
    withContext(Dispatchers.IO)
    {
        val reports = staffService.getRportForHospital( hname,token).await() as List<Report>
        reportDao.insertAll(reports)
        return@withContext reportDao.getAllReport()
    }

    suspend fun postReport(report: Report,username:String,token: String): LiveData<Report> =
        withContext(Dispatchers.IO){
           val report = staffService.postReport(report = report as NetworkReport,username = username,token = token).await() as Report
            reportDao.insertReport(report)
            return@withContext reportDao.getReportByNo(report.reportNo)
        }


}