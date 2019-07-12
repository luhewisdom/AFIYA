package com.example.afiyahospital.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.afiyahospital.repository.CardRepository
import com.example.afiyahospital.repository.HospitalRepository
import com.example.loginpage.viewmodel.HospitalViewModel

class CardViewModelFactory
    (private val repository: CardRepository): ViewModelProvider.NewInstanceFactory(){

    @Suppress("UNCHECED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =   CardViewModel(repository) as T
}