package com.example.afiyahospital.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.afiyahospital.data.HospitalApiData
import com.example.afiyahospital.data.HospitalApiService
import com.example.afiyahospital.repository.HospitalApiRepository
import com.example.loginpage.repository.HospitalRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class HospitalApiViewModel:ViewModel() {
    private val hospitalApiRepository:HospitalApiRepository
    init {
        val hospitalApiService = HospitalApiService.getInstance()
        hospitalApiRepository = HospitalApiRepository(hospitalApiService)
    }

    private  val _getResponse = MutableLiveData<Response<HospitalApiData>>()
    val getResponse:LiveData<Response<HospitalApiData>>
        get() = _getResponse

    fun getHospitalById(id:Long) = viewModelScope.launch {
        _getResponse.postValue(hospitalApiRepository.getOneHospital(id))
    }

}