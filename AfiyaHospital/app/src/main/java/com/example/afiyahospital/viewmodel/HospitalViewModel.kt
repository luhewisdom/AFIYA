package com.example.loginpage.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.loginpage.data.AfiaDataBase
import com.example.loginpage.data.Hospital
import com.example.loginpage.data.HospitalDao
import com.example.loginpage.data.User
import com.example.loginpage.repository.HospitalRepository
import com.example.loginpage.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class HospitalViewModel(application: Application):AndroidViewModel(application)
{
    private val hospitalRepository: HospitalRepository
    val allUsers: LiveData<List<Hospital>>
    init {
        val hospitalDao = AfiaDataBase.getDatabase(application,viewModelScope).hospitalDao()
        hospitalRepository = HospitalRepository(hospitalDao)
        allUsers = hospitalRepository.allHospital()

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


}