package com.example.loginpage.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.afiyahospital.data.Card
import com.example.afiyahospital.network.UserService
import com.example.afiyahospital.repository.ReportRepository
import com.example.loginpage.data.AfiaDataBase
import com.example.loginpage.data.User
import com.example.loginpage.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class UserViewModel(private val userRepository: UserRepository): ViewModel()
{

    private val _allUserResponse = MutableLiveData<List<User>>()
    private  var viewModelJob = Job()
    val hospitalAppointments:   LiveData<List<User>>
        get() = _allUserResponse
    fun getHospitalAppointments(token: String) =
        viewModelScope.launch {
            _allUserResponse.postValue( userRepository.allUser() as List<User>)
        }

    fun insertUser(user: User) = viewModelScope.launch(Dispatchers.IO) {
        userRepository.insertUser(user)
    }

    fun oneUser(uname:String,password:String):Boolean
    {
        return userRepository.oneUser(uname,password)
    }
    fun deleteUser(user: User) = viewModelScope.launch(Dispatchers.IO) {
        userRepository.deleteUser(user)
    }
}


