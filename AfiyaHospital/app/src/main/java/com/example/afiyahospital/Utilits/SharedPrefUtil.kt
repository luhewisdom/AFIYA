package com.example.afiyahospital.Utilits

import android.content.Context
import android.content.SharedPreferences
import com.example.afiyahospital.data.domain.AuthBody
import java.util.*

object SharedPrefUtil {
    fun savePreference(sharedPref: SharedPreferences,token:String,username:String,role:String){
        with(sharedPref.edit()){
            putString(TOKEN_KEY,token)
            putString(USERNAME_KEY,username)
            putString(USER_ROLE,role)
            commit()
        }
    }
    fun getSharedPref(context: Context):SharedPreferences{
        return context.getSharedPreferences(SHARED_PREFERENCE_FILE, Context.MODE_PRIVATE)
    }
    fun updatePreference(sharedPref: SharedPreferences,token:String,expirationDate:Date,issuedDate:Date){
        with(sharedPref.edit()){
            putString(TOKEN_KEY,token)
            putString(EXP_DATE_KEY,expirationDate.time.toString())
            putString(ISSUED_DATE_KEY,issuedDate.time.toString())
            putLong(LAST_LOGIN_KEY,Date().time)
            commit()
        }
    }
    fun clearPreference(sharedPref: SharedPreferences){
       with(sharedPref.edit()){
           clear()
           commit()
       }
    }
    fun isLoggedIn(sharedPref: SharedPreferences):Boolean{
        return sharedPref.getBoolean(ISLOGGEDIN_KEY, DEFAULT_BOOL_VALUE_SHARED_PREF)

    }
    fun getToken(sharedPref: SharedPreferences):String{
        return """Bearer ${sharedPref.getString(TOKEN_KEY,DEFAULT_VALUE_SHARED_PREF)}"""
    }
    fun getUsername(sharedPref: SharedPreferences):String{
        return sharedPref.getString(USERNAME_KEY, DEFAULT_VALUE_SHARED_PREF)
    }
    fun getExpTime(sharedPref: SharedPreferences):String{
        return sharedPref.getString(EXP_DATE_KEY, DEFAULT_VALUE_SHARED_PREF)
    }
    fun getIssuedTime(sharedPref: SharedPreferences):String{
        return sharedPref.getString(ISSUED_DATE_KEY, DEFAULT_VALUE_SHARED_PREF)
    }
    fun getLastLoginTime(sharedPref: SharedPreferences):Long{
        return sharedPref.getLong(LAST_LOGIN_KEY, DEFAULT_LONG_VALUE_SHARED_PREF)
    }
    fun getPassword(sharedPref: SharedPreferences):String{
        return sharedPref.getString(PASSWORD_KEY, DEFAULT_VALUE_SHARED_PREF)
    }
    fun isTokenExpired(sharedPref: SharedPreferences):Boolean{
        val validityLength = getExpTime(sharedPref).toLong()  - getIssuedTime(sharedPref).toLong()
        if (Date().time > getLastLoginTime(sharedPref)+validityLength) return true
        return false
    }
    fun getSavedLoginCredentials(sharedPref: SharedPreferences): AuthBody {
        return AuthBody(
            this.getUsername(sharedPref),
            this.getPassword(sharedPref)
        )
    }
}