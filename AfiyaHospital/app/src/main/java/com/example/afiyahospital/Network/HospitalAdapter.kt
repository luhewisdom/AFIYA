package com.example.afiyahospital.network

import android.util.JsonReader
import com.example.afiyahospital.data.Hospital
import com.squareup.moshi.JsonAdapter

import com.squareup.moshi.Moshi

class HospitalAdapter (moshi: Moshi) {
    private val hospitalAdapter: JsonAdapter<NetworkHospital> = moshi.adapter(NetworkHospital::class.java)

    fun parse(reader: JsonReader): Sequence<NetworkHospital> {
        return sequence {

        }
    }
}