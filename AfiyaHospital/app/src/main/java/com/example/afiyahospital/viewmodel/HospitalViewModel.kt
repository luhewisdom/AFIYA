package com.example.loginpage.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.afiyahospital.data.Hospital
import com.example.afiyahospital.repository.HospitalRepository
import com.example.loginpage.data.AfiaDataBase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.io.IOException


class HospitalViewModel(private val hospitalRepository: HospitalRepository):ViewModel()
{

    private  var viewModelJob = Job()

    val hospitals:LiveData<List<Hospital>>

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
            catch (networkError:IOException)
            {

            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
   //////////////////////////////////////////////////////////


    fun insertHospital(hospital: Hospital) = viewModelScope.launch(Dispatchers.IO) {
        hospitalRepository.insertHospital(hospital)
    }
    fun updateHospital(hospital: Hospital) = viewModelScope.launch(Dispatchers.IO) {
        hospitalRepository.updateHospital(hospital)
    }

    fun deleteHospital(hospital: Hospital) = viewModelScope.launch(Dispatchers.IO) {
        hospitalRepository.deleteHospital(hospital)
    }
    ////////////////////////////////////////////////////////
}