package com.example.afiyahospital.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.loginpage.viewmodel.HospitalViewModel

class HospitalViewModelFactory (val app: Application): ViewModelProvider.Factory{

    @Suppress("UNCHECED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(HospitalViewModel::class.java))
        {
            return HospitalViewModel(app) as T

        }
        throw IllegalArgumentException("Unable to construct viewmodel")
    }
}