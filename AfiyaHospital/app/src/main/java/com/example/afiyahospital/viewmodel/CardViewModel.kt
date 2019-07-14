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

   private val _cards = MutableLiveData<List<Card>>()

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
    private fun setAppointment(card:Card,hname:String,token:String)=
        viewModelScope.launch {

        }


    private fun refreshCardOne(cno:String,token: String)
    {
        viewModelScope.launch {
            try {
                cardRepository.refreshOneCard(cno,token)
            }
            catch (networkError:IOException)
            {
                Log.d("No Connection", "No connection")
            }
        }
    }



    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }


}