package com.example.afiyahospital.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.afiyahospital.data.Card
import com.example.afiyahospital.data.Hospital
import com.example.afiyahospital.repository.CardRepository
import com.example.afiyahospital.repository.HospitalRepository


class CardDetailViewModelFactory (private val repository: CardRepository,private val cno:String): ViewModelProvider.NewInstanceFactory(){

    @Suppress("UNCHECED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =   CardDetailViewModel(repository,cno) as T
}