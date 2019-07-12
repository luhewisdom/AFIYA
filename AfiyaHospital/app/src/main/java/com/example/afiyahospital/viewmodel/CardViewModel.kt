package com.example.afiyahospital.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.afiyahospital.data.Card
import com.example.afiyahospital.data.Hospital
import com.example.afiyahospital.repository.CardRepository
import com.example.afiyahospital.repository.HospitalRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.io.IOException

class CardViewModel(private val cardRepository: CardRepository): ViewModel()
{
    private  var viewModelJob = Job()

    val cards: LiveData<List<Card>>
    //private var allUsers: MutableLiveData<List<Hospital>>
    init {
        cards = cardRepository.allCards()
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

    private fun refershCardFromRepository(token: String){
        viewModelScope.launch {
            try {
                cardRepository.refereshCard(token)
                _eventNetworkError.value = false
                _isNetworkErrorShown.value = false
            }
            catch (networkError: IOException)
            {
                Log.d("No Connection", "No connection")
            }
        }
    }

    private fun refreshCardOne(cno:String,token: String)
    {
        viewModelScope.launch {
            try {
                cardRepository.refreshOneHospital(cno,token)
            }
            catch (networkError:IOException)
            {
                Log.d("No Connection", "No connection")
            }
        }
    }

    private fun setAppointment(card:Card,hname:String,token:String)=
        viewModelScope.launch {

        }
    private fun getAppointment(token: String) =
        viewModelScope.launch {
            cardRepository.getAppointment(token)
        }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }


}