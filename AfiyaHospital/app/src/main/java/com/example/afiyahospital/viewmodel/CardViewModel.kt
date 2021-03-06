package com.example.afiyahospital.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.afiyahospital.data.Card
import com.example.afiyahospital.data.Hospital
import com.example.afiyahospital.data.Report
import com.example.afiyahospital.network.NetworkCard
import com.example.afiyahospital.repository.CardRepository
import com.example.afiyahospital.repository.HospitalRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import java.io.IOException
import java.net.ConnectException

class CardViewModel(private val cardRepository: CardRepository): ViewModel()
{
    private  var viewModelJob = Job()

   private val _cards = MutableLiveData<List<Card>>()

    private val _oneCard = MutableLiveData<Card>()


    private val _reports = MutableLiveData<List<Report>>()

    val reports : LiveData<List<Report>>
    get() = _reports

    val card:LiveData<Card>
    get() = _oneCard

    val cards: LiveData<List<Card>>
    get() = _cards



     fun refershCardFromRepository(token: String){
        viewModelScope.launch {
            try {
                 val cards = cardRepository.refereshCard(token)
                _cards.postValue(cards)
            }
            catch (networkError: IOException)
            {
                Log.d("No Connection", "No connection")
            }

        }
    }

    fun refershReportFromRepository(token: String){
        viewModelScope.launch {
            try {
                val cards = cardRepository.getAppointments(token)
                _reports.postValue(cards)
            }
            catch (networkError: IOException)
            {
                Log.d("No Connection", "No connection")
            }

        }
    }
    fun setAppointment(card:NetworkCard,token:String)=
        viewModelScope.launch {
            try {
               _oneCard.postValue(cardRepository.setAppointment(card,token))

            }
            catch (e: ConnectException){
                this.coroutineContext.cancel()
            }
        }


    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }


}