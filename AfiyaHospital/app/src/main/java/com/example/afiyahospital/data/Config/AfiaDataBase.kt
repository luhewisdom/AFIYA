package com.example.loginpage.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.example.afiyahospital.Worker.HospitalWorker
import com.example.afiyahospital.data.*
import com.example.afiyahospital.data.Config.DateConverter
import kotlinx.coroutines.CoroutineScope


@Database(entities = arrayOf(User::class,
                    Hospital::class,
                    Report::class,
                    Role::class,
                    Card::class
                    ), exportSchema = false,version = 13)
@TypeConverters(DateConverter::class)
abstract class AfiaDataBase:RoomDatabase() {
    abstract fun userDao():UserDao
    abstract fun hospitalDao():HospitalDao
    abstract fun roleDao():RoleDao
    abstract fun reportDao():ReportDao
    abstract fun cardDao():CardDao

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
                ).addCallback(object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        val request = OneTimeWorkRequestBuilder<HospitalWorker>().build()
                        WorkManager.getInstance(context).enqueue(request)
                    }})
                    .fallbackToDestructiveMigration().build()

                INSTANCE = instance
                return instance
            }

        }
    }

}