package com.example.afiyahospital.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.afiyahospital.data.Hospital
import com.example.afiyahospital.repository.CardRepository
import com.example.afiyahospital.repository.HospitalRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.io.IOException

class CardViewModel(private val cardRepository: CardRepository): ViewModel()
{
    private  var viewModelJob = Job()

    val hospitals: LiveData<List<Hospital>>
    //private var allUsers: MutableLiveData<List<Hospital>>
    init {
        hospitals = hospitalRepository.allHospital()
        refershHospitalFromRepository()
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

    private fun refershHospitalFromRepository(){
        viewModelScope.launch {
            try {
                hospitalRepository.refershHospital()
                _eventNetworkError.value = false
                _isNetworkErrorShown.value = false
            }
            catch (networkError: IOException)
            {

            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}