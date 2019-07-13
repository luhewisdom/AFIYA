package com.example.afiyahospital.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.afiyahospital.data.Hospital
import com.example.afiyahospital.repository.HospitalRepository

class HospitalDetailViewModel (private val hospitalRepository: HospitalRepository, private val id:Long): ViewModel() {
    val hospital: LiveData<Hospital>
    init {
        hospital = hospitalRepository.oneHospital(id)
    }

}