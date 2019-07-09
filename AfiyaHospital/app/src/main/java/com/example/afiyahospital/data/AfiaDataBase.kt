package com.example.loginpage.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.afiyahospital.data.Card
import com.example.afiyahospital.data.Hospital
import com.example.afiyahospital.data.Report
import kotlinx.coroutines.CoroutineScope


@Database(entities = arrayOf(User::class,
                    Hospital::class,
                    Report::class,
                    Card::class
                    ),version = 4)
abstract class AfiaDataBase:RoomDatabase() {
    abstract fun userDao():UserDao
    abstract fun hospitalDao():HospitalDao


    companion object {
        @Volatile
        private var INSTANCE: AfiaDataBase? = null
///, scope:CoroutineScope
        fun getDatabase(context: Context):AfiaDataBase {

            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {

                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AfiaDataBase::class.java, "afia_database"
                ).fallbackToDestructiveMigration().build()

                INSTANCE = instance
                return instance
            }

        }
    }

}