/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.afiyahospital.Utilits

import android.content.Context
import com.example.afiyahospital.network.CardService

import com.example.afiyahospital.network.HospitalService
import com.example.afiyahospital.network.StaffService
import com.example.afiyahospital.network.UserService
import com.example.afiyahospital.repository.CardRepository
import com.example.afiyahospital.repository.HospitalRepository
import com.example.afiyahospital.repository.ReportRepository
import com.example.afiyahospital.repository.StaffRepository
import com.example.afiyahospital.viewmodel.*
import com.example.loginpage.data.AfiaDataBase
import com.example.loginpage.data.HospitalDao
import com.example.loginpage.repository.UserRepository
import com.example.loginpage.viewmodel.HospitalViewModel
import com.google.gson.Gson
import com.google.gson.GsonBuilder

/**
 * Static methods used to inject classes needed for various Activities and Fragments.
 */
object InjectorUtils {

    private fun getHospitalRepository(context: Context): HospitalRepository {
        return HospitalRepository(AfiaDataBase.getDatabase(context).hospitalDao(), HospitalService.getInstance())

    }
    fun provideHositalViewModelFactory(context: Context):HospitalViewModelFactory{
        val repository = getHospitalRepository(context)
        return HospitalViewModelFactory(repository)
    }

    private fun getCardRepository(context: Context):CardRepository{
        return CardRepository(AfiaDataBase.getDatabase(context).cardDao(), CardService.getInstance())
    }
    fun provideCardViewModelFactory(context: Context):CardViewModelFactory{
        val repository = getCardRepository(context)
        return CardViewModelFactory(repository)
    }

    private fun getReportRepository(context: Context):ReportRepository{
        return ReportRepository(AfiaDataBase.getDatabase(context).reportDao(), StaffService.getInstance())
    }

    fun provideReportViewModelFactory(context: Context):ReportViewModelFactory{
        return ReportViewModelFactory(getReportRepository(context))
    }

    private fun getStaffRepository(context: Context):StaffRepository{
        return StaffRepository(AfiaDataBase.getDatabase(context).cardDao(), StaffService.getInstance(), HospitalService.getInstance(),AfiaDataBase.getDatabase(context).hospitalDao())
    }

    fun provideReStaffViewModelFactory(context: Context):StaffViewModelFactory{
        return StaffViewModelFactory(getStaffRepository(context))
    }

    private fun getUserRepoostiory(context: Context):UserRepository{
        return UserRepository(AfiaDataBase.getDatabase(context).userDao(),AfiaDataBase.getDatabase(context).roleDao(),
            UserService.getInstance())
    }
    fun provideStaffViewModelFactory(context: Context):UserViewModelFactory{
        return UserViewModelFactory(getUserRepoostiory(context))
    }
}
