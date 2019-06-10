package com.example.loginpage.repository

import androidx.lifecycle.LiveData
import com.example.loginpage.data.Hospital
import com.example.loginpage.data.HospitalDao
import com.example.loginpage.data.User

class HospitalRepository(private val hospitalDao: HospitalDao) {
    fun allHospital(): LiveData<List<Hospital>> = hospitalDao.getAllHospital()

    fun oneHospital(hname:String): LiveData<Hospital> {
        return hospitalDao.getHospital(hname)
    }


    fun insertHospital(hospital: Hospital):Long{
        return hospitalDao.insertHospital(hospital)
    }

    fun updateHospital(hospital: Hospital):Int
    {
        return hospitalDao.update(hospital)
    }
    fun deleteHospital(hospital: Hospital):Int{

        return hospitalDao.deleteHospital(hospital)
    }
}