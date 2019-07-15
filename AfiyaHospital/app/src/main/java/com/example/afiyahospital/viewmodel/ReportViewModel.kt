package com.example.afiyahospital.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.afiyahospital.data.Card
import com.example.afiyahospital.data.Report
import com.example.afiyahospital.repository.CardRepository
import com.example.afiyahospital.repository.ReportRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.io.IOException

class ReportViewModel (private val reportRepository: ReportRepository): ViewModel()
{
    private val _allReportResponse = MutableLiveData<List<Report>>()
    private  var viewModelJob = Job()
    val reports: LiveData<List<Report>>
        get() = _allReportResponse
    fun getHospitalAppointments(hname:String,token: String) =
        viewModelScope.launch {
            try {
                _allReportResponse.postValue(reportRepository.getReportFromHospital(hname,token) as List<Report>)
            }
            catch (networkError: IOException)
            {
                Log.d("No Connection", "No connection")
            }
        }

    private var _eventNetworkError = MutableLiveData<Boolean>(false)

    val eventNetworkError: LiveData<Boolean>
        get() = _eventNetworkError

    private var _isNetworkErrorShown = MutableLiveData<Boolean>(false)
    val isNetworkErrorShown: LiveData<Boolean>
        get() = _isNetworkErrorShown

    fun onNetworkErrorShown() {
        _isNetworkErrorShown.value = true
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}