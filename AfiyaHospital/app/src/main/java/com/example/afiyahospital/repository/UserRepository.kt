package com.example.loginpage.repository

import androidx.lifecycle.LiveData
import com.example.loginpage.data.UserDao
import com.example.loginpage.data.User

class UserRepository(private val userDao: UserDao) {

    fun allUser():LiveData<List<User>> =userDao.getAllUsers()

    fun oneUser(uname:String,password:String): Boolean =
        userDao.getUser(uname,password)

    fun insertUser(user: User){
        userDao.insert(user)
    }

    fun updateUser(user: User):Int
    {
        return userDao.update(user)
    }
    fun deleteUser(user: User):Int{
        return userDao.deleteUser(user)
    }
}