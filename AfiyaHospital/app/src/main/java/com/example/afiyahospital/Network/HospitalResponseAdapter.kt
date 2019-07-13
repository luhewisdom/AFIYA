package com.example.afiyahospital.network

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.Moshi
import java.io.IOException



class HospitalResponseAdapter  : JsonAdapter<NetworkHospital>() {
    override fun toJson(writer: JsonWriter, value: NetworkHospital?) {
        val moshi = Moshi.Builder().build()
        val jsonAdapter = moshi.adapter<Any>(NetworkHospital::class.java!!)

        writer.value(jsonAdapter.toJson(value))
    }

    override fun fromJson(reader: JsonReader): NetworkHospital{
        val moshi = Moshi.Builder().build()
        val jsonAdapter = moshi.adapter<Any>(NetworkHospital::class.java!!)

        return jsonAdapter.fromJson(reader.nextString()) as NetworkHospital
    }



}