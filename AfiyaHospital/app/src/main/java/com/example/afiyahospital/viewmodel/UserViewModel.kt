package com.example.loginpage.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.afiyahospital.network.UserService
import com.example.afiyahospital.repository.ReportRepository
import com.example.loginpage.data.AfiaDataBase
import com.example.loginpage.data.User
import com.example.loginpage.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(private val userRepository: UserRepository): ViewModel()
{


}

//    private val userRepository:UserRepository
//    val allUsers:LiveData<List<User>>
//    init {
//        val afiaDao = AfiaDataBase.getDatabase(application).userDao()
//        val roleDao = AfiaDataBase.getDatabase(application).roleDao()
//        userRepository = UserRepository(afiaDao,userService = UserService.getInstance(),roleDao = roleDao)
//        allUsers = userRepository.allUser()
//
//    }
//    fun insertUser(user: User) = viewModelScope.launch(Dispatchers.IO) {
//        userRepository.insertUser(user)
//    }
//
//    fun oneUser(uname:String,password:String):Boolean
//    {
//        return userRepository.oneUser(uname,password)
//    }
//    fun deleteUser(user: User) = viewModelScope.launch(Dispatchers.IO) {
//        userRepository.deleteUser(user)
//    }
