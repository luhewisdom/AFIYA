package com.example.loginpage.repository

import androidx.lifecycle.LiveData
import com.example.afiyahospital.data.Role
import com.example.afiyahospital.data.RoleDao
import com.example.afiyahospital.network.NetworkRole
import com.example.afiyahospital.network.NetworkUser
import com.example.afiyahospital.network.UserService
import com.example.loginpage.data.UserDao
import com.example.loginpage.data.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRepository(private val userDao: UserDao, private val roleDao: RoleDao,private val userService: UserService) {

    suspend fun registerStaffHospital(user: User,level:String,token:String) =
        withContext(Dispatchers.IO){
            userService.registerHospital(user as NetworkUser,level , token) as User
        }
    suspend fun listOfHospitalUsers(token: String) =
        withContext(Dispatchers.IO){
            val users = userService.getAllUsers() as List<User>
            userDao.insertAll(users)
        }
    suspend fun registerRole(role:Role , token: String)=
        withContext(Dispatchers.IO){
           val role =  userService.registerRole(role as NetworkRole , token).await() as Role
            roleDao.insertRole(role)

        }

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