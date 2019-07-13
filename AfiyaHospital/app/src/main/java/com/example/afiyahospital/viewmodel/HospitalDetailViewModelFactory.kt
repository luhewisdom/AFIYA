package com.example.afiyahospital.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.afiyahospital.repository.HospitalRepository
import com.example.loginpage.viewmodel.HospitalViewModel

class HospitalDetailViewModelFactory (private val repository: HospitalRepository, private val id:Long): ViewModelProvider.NewInstanceFactory(){

    @Suppress("UNCHECED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = HospitalDetailViewModel(repository,id) as T
}