package com.example.loginpage.repository

import androidx.lifecycle.LiveData
import com.example.loginpage.data.AfiaDao
import com.example.loginpage.data.User

class AfiaRepository(private val afiaDao: AfiaDao) {

    fun allUser():LiveData<List<User>> = afiaDao.getAllUsers()

    fun oneUser(uname:String,password:String): Boolean =
        afiaDao.getUser(uname,password)

    fun insertUser(user: User){
        afiaDao.insert(user)
    }

    fun updateUser(user: User)
    {
        afiaDao.update(user)
    }
    fun deleteUser(user: User){
        afiaDao.deleteUser(user)
    }
}