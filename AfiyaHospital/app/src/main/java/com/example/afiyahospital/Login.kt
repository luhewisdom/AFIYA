package com.example.loginpage


import android.content.Context
import android.os.AsyncTask
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.afiyahospital.R
import com.example.afiyahospital.databinding.FragmentLoginBinding
import com.example.loginpage.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.fragment_login.view.*



class Login : Fragment() {

    private lateinit var  usernameEditText:EditText
    private lateinit var passwordEditText : EditText
    lateinit var userViewModel: UserViewModel
    var userOne:Boolean = false


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val binding :FragmentLoginBinding = DataBindingUtil.inflate(
            inflater,R.layout.fragment_login,container,false
        )

        usernameEditText = binding.usernameId
        passwordEditText = binding.passId
        val loginButton = binding.loginbuttonId
        val signupButton = binding.signupbuttonId

        userViewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)
        loginButton.setOnClickListener {
           AsyncTask.execute {
                userOne= userViewModel.oneUser(usernameEditText.text.toString(),passwordEditText.text.toString())

           }
            if(!emptyValidation())
            {
                if(userOne == true)
                {

                    view?.findNavController()?.navigate(R.id.action_login_to_hospitalPage)

                }
                else
                {
                    Toast.makeText(activity, "Unregistered user, or incorrect", Toast.LENGTH_SHORT).show()
                }
            }
            else{
                Toast.makeText(activity, "Empty Fields", Toast.LENGTH_SHORT).show()
            }

        }
        signupButton.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_login_to_signUp)

        }
        return binding.root
    }

    private fun emptyValidation():Boolean
    {
        if (TextUtils.isEmpty(usernameEditText.text.toString())|| TextUtils.isEmpty(passwordEditText.text.toString()))
        {
            return true
        }
        return false
    }

}