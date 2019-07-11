package com.example.afiyahospital.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.afiyahospital.repository.HospitalRepository
import com.example.loginpage.viewmodel.HospitalViewModel

class HospitalViewModelFactory(private val repository: HospitalRepository): ViewModelProvider.NewInstanceFactory(){

    @Suppress("UNCHECED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = HospitalViewModel(repository) as T
}