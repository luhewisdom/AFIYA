package com.example.loginpage.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.afiyahospital.data.Hospital
import com.example.loginpage.data.AfiaDataBase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch


class HospitalViewModel(application: Application):AndroidViewModel(application)
{

    private  var viewModelJob = Job()


    private val hospitalRepository: HospitalRepository
    private var allUsers: MutableLiveData<List<Hospital>>
    init {
        val hospitalDao = AfiaDataBase.getDatabase(application,viewModelScope).hospitalDao()
        hospitalRepository = HospitalRepository(hospitalDao)
        allUsers = hospitalRepository.allHospital() as MutableLiveData<List<Hospital>>

    }
    fun insertHospital(hospital: Hospital) = viewModelScope.launch(Dispatchers.IO) {
        hospitalRepository.insertHospital(hospital)
    }
    fun updateHospital(hospital: Hospital) = viewModelScope.launch(Dispatchers.IO) {
        hospitalRepository.updateHospital(hospital)
    }

    fun deleteHospital(hospital: Hospital) = viewModelScope.launch(Dispatchers.IO) {
        hospitalRepository.deleteHospital(hospital)
    }


    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}