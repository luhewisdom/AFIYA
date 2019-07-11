package com.example.afiyahospital.repository

import androidx.lifecycle.LiveData
import com.example.afiyahospital.data.Card
import com.example.afiyahospital.data.CardDao
import com.example.afiyahospital.data.LoginResponse
import com.example.afiyahospital.network.CardService
import com.example.afiyahospital.network.LoginService
import com.example.afiyahospital.network.NetworkUser
import com.example.loginpage.data.User
import com.example.loginpage.data.UserDao
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import java.net.ConnectException

class LoginRepository constructor(private val userDao: UserDao, private val  loginService: LoginService) {



    suspend fun loginApi(username:String,password:String): Response<LoginResponse> =
        withContext(Dispatchers.IO){
           loginService.getLogin(username,password).await()

        }

    suspend fun registerClient(user:User): Response<NetworkUser> =
        withContext(Dispatchers.IO){
            userDao.insert(user)
            loginService.registerClient(user as NetworkUser).await()
        }
}