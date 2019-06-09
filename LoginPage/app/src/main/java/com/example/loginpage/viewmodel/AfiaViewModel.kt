package com.example.loginpage.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.loginpage.data.AfiaDataBase
import com.example.loginpage.data.User
import com.example.loginpage.repository.AfiaRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AfiaViewModel(application:Application):AndroidViewModel(application) {
    private val afiaRepository:AfiaRepository
    val allUsers:LiveData<List<User>>
    init {
        val afiaDao = AfiaDataBase.getDatabase(application,viewModelScope).userDao()
        afiaRepository = AfiaRepository(afiaDao)
        allUsers = afiaRepository.allUser()

    }
    fun insertUser(user: User) = viewModelScope.launch(Dispatchers.IO) {
        afiaRepository.insertUser((user))
    }

    fun oneUser(uname:String,password:String):Boolean
    {
        return afiaRepository.oneUser(uname,password)
    }


}