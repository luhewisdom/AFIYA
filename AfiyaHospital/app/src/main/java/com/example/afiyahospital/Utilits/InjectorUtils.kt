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

import com.example.afiyahospital.network.HospitalService
import com.example.afiyahospital.repository.HospitalRepository
import com.example.afiyahospital.viewmodel.HospitalViewModelFactory
import com.example.loginpage.data.AfiaDataBase
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

}
