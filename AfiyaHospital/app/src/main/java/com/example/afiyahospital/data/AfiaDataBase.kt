package com.example.loginpage.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope


@Database(entities = arrayOf(User::class,Hospital::class),version = 3)
abstract class AfiaDataBase:RoomDatabase() {
    abstract fun userDao():UserDao
    abstract fun hospitalDao():HospitalDao


    companion object {
        @Volatile
        private var INSTANCE: AfiaDataBase? = null

        fun getDatabase(context: Context, scope:CoroutineScope):AfiaDataBase {

            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {

                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AfiaDataBase::class.java, "afia_database"
                ).build()

                INSTANCE = instance
                return instance
            }

        }
    }

}