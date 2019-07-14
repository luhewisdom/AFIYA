package com.example.afiyahospital.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.afiyahospital.Utilits.AuthenticationState
import com.example.afiyahospital.Utilits.SharedPrefUtil
import com.example.afiyahospital.data.LoginResponse
import com.example.afiyahospital.data.domain.AuthBody
import com.example.afiyahospital.repository.LoginRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import retrofit2.Response
import java.net.ConnectException
import kotlin.coroutines.coroutineContext

class LoginViewModel(private val loginRepository: LoginRepository,context: Context): ViewModel(){
    val autententicationState = MutableLiveData<AuthenticationState>()
    init {
        val sharedPref = SharedPrefUtil.getSharedPref(context)
        if (SharedPrefUtil.isLoggedIn(sharedPref)){
            if (!SharedPrefUtil.isTokenExpired(sharedPref))
            {
                autententicationState.value = AuthenticationState.AUTHENTICATED
            }
            else
            {
                autententicationState.value = AuthenticationState.EXPIRED_TOKEN
            }

        }
        else{
            autententicationState.value = AuthenticationState.UNAUTHENTICATED
        }
    }
    private val _loginREsponse = MutableLiveData<Response<LoginResponse>>()
    val loginResponse: LiveData<Response<LoginResponse>>
    get() = _loginREsponse

    fun login(username:String,pass:String) =
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _loginREsponse.postValue(loginRepository.loginApi(username,pass))
            }
            catch (e:ConnectException){
                this.coroutineContext.cancel()
            }
        }
    fun refuseAuthentication(){
        autententicationState.value = AuthenticationState.INVALID_AUTHENTICATION
    }
    fun acceptAuthentication(){
        autententicationState.value = AuthenticationState.AUTHENTICATED
    }
    fun expiredAuthentication(){
        autententicationState.value = AuthenticationState.EXPIRED_TOKEN
    }

}