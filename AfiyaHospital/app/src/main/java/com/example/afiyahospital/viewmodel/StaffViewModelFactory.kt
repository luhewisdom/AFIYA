package com.example.afiyahospital.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.afiyahospital.repository.ReportRepository
import com.example.afiyahospital.repository.StaffRepository

class StaffViewModelFactory (private val staffRepository: StaffRepository): ViewModelProvider.NewInstanceFactory(){

    @Suppress("UNCHECED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =   StaffViewModel(staffRepository) as T
}