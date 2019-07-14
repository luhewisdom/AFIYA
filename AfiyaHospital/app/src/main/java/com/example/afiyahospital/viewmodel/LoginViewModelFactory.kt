package com.example.afiyahospital.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.afiyahospital.repository.HospitalRepository
import com.example.afiyahospital.repository.LoginRepository
import com.example.loginpage.viewmodel.HospitalViewModel

class LoginViewModelFactory (private val repository:LoginRepository,val context: Context ): ViewModelProvider.NewInstanceFactory(){

    @Suppress("UNCHECED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =LoginViewModel(repository,context) as T
}