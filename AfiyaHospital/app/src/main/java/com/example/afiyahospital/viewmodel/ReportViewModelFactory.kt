package com.example.afiyahospital.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.afiyahospital.repository.CardRepository
import com.example.afiyahospital.repository.ReportRepository

class ReportViewModelFactory  (private val reportRepository: ReportRepository): ViewModelProvider.NewInstanceFactory(){

    @Suppress("UNCHECED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =   ReportViewModel(reportRepository) as T
}