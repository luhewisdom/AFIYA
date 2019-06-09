package com.example.loginpage

import android.content.Intent
import android.content.res.Configuration
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProviders
import com.example.loginpage.data.User
import com.example.loginpage.viewmodel.AfiaViewModel

class MainActivity : AppCompatActivity(),Login.OnSignUpButtonClicked, SignUp.OnRegisteredButtonClicked,Login.OnLoginButtonClicked {
    override fun onLoginClickede() {
        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE)
        {

            val userFragment = UserPage()
                supportFragmentManager.beginTransaction()
                .replace(R.id.userFrame,userFragment)
                .commit()
        }
        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT)
        {
            val userFragment = UserPage()
            supportFragmentManager.beginTransaction()
                .replace(R.id.portrait_frame,userFragment).commit()
        }
    }

    override fun onRegisteredClicked(user: User) {
        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE)
        {

            val loginFragment = Login()
            supportFragmentManager.beginTransaction()
                .replace(R.id.login_fragment,loginFragment)
                .commit()
        }
        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT)
        {
            val loginFragment = Login()
            supportFragmentManager.beginTransaction()
                .replace(R.id.portrait_frame,loginFragment).commit()
        }


    }

    override fun onSignupclicked() {
        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE)
        {
            val signUpFragment = SignUp()
            supportFragmentManager.beginTransaction()
                .replace(R.id.userFrame,signUpFragment).commit()
        }
        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT)
        {
            val signUpFragment = SignUp()
            supportFragmentManager.beginTransaction()
                .replace(R.id.portrait_frame,signUpFragment).commit()
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT)
        {
            val loginFragment = Login()
            supportFragmentManager.beginTransaction()
                .add(R.id.portrait_frame,loginFragment)
                .addToBackStack(null)
                .commit()
        }


    }

}
