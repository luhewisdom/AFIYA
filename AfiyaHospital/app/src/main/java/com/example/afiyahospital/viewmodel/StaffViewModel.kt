package com.example.afiyahospital.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.afiyahospital.data.Card
import com.example.afiyahospital.data.Hospital
import com.example.afiyahospital.repository.ReportRepository
import com.example.afiyahospital.repository.StaffRepository
import com.example.loginpage.data.User
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.io.IOException

class StaffViewModel (private val staffRepository: StaffRepository): ViewModel(){

    private val _allCardResponse = MutableLiveData<List<Card>>()
    private  var viewModelJob = Job()
    val hospitalAppointments:   LiveData<List<Card>>
       get() = _allCardResponse
    fun getHospitalAppointments(token: String) =
        viewModelScope.launch {
            _allCardResponse.postValue(staffRepository.gethospitalAppointment(token) as List<Card>)
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