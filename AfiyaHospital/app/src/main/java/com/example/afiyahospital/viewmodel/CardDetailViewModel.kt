package com.example.afiyahospital.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.afiyahospital.data.Card
import com.example.afiyahospital.repository.CardRepository

class CardDetailViewModel(private val repository: CardRepository, private val cno:String): ViewModel() {
    val card: LiveData<Card>
    init {
        card = repository.oneHospital(cno)
    }

}
