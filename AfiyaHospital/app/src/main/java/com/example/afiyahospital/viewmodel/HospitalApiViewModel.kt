package com.example.afiyahospital.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.afiyahospital.data.Hospital

import com.example.afiyahospital.data.HospitalService
import com.example.afiyahospital.repository.HospitalApiRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class HospitalApiViewModel:ViewModel() {
    //private val hospitalApiRepository:HospitalApiRepository
    init {


    }

    private  val _getResponse = MutableLiveData<Response<Hospital>>()
    val getResponse:LiveData<Response<Hospital>>
        get() = _getResponse

//    fun getHospitalById(id:Long) = viewModelScope.launch {
//        _getResponse.postValue(hospitalApiRepository.getOneHospital(id))
//    }

}