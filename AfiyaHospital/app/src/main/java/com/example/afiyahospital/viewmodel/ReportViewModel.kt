package com.example.afiyahospital.viewmodel

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

class ReportViewModel (private val reportRepository: ReportRepository): ViewModel()
{
    private val _allReportResponse = MutableLiveData<List<Report>>()
    private  var viewModelJob = Job()
    val hospitalAppointments: LiveData<List<Report>>
        get() = _allReportResponse
    fun getHospitalAppointments(hname:String,token: String) =
        viewModelScope.launch {
            _allReportResponse.postValue(reportRepository.getReportFromHospital(hname,token) as List<Report>)
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