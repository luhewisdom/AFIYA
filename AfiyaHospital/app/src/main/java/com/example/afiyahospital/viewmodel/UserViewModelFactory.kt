package com.example.afiyahospital.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.afiyahospital.repository.ReportRepository
import com.example.loginpage.data.User
import com.example.loginpage.repository.UserRepository
import com.example.loginpage.viewmodel.UserViewModel

class UserViewModelFactory (private val userRepository: UserRepository): ViewModelProvider.NewInstanceFactory(){

    @Suppress("UNCHECED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =  UserViewModel(userRepository) as T
}