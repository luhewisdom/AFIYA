package com.example.afiyahospital.Worker

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.afiyahospital.data.Hospital
import com.example.loginpage.data.AfiaDataBase
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import kotlinx.coroutines.coroutineScope
import java.io.Reader

class HospitalWorker(context: Context,workerParameters: WorkerParameters):CoroutineWorker(context,workerParameters) {
    private val TAG by lazy { HospitalWorker::class.java.simpleName }

    override suspend fun doWork(): Result = coroutineScope {

        try {
            applicationContext.assets.open("users.json").use { inputStream ->
                JsonReader(inputStream.reader() as Reader?).use { jsonReader ->
                    val userType = object : TypeToken<List<Hospital>>() {}.type
                    val hospital: List<Hospital> = Gson().fromJson(jsonReader,userType)
                    val database = AfiaDataBase.getDatabase(applicationContext)
                    database.hospitalDao().insertAll(hospital)
                    Result.success()
                }
            }
        } catch (ex: Exception) {
            Log.e(TAG, "Error seeding database", ex)
            Result.failure()
        }
    }
}