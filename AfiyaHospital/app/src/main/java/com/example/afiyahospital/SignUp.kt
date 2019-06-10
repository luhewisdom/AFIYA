package com.example.loginpage


import android.content.Context
import android.os.AsyncTask
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.afiyahospital.MainActivity
import com.example.afiyahospital.R
import com.example.afiyahospital.databinding.FragmentSignUpBinding
import com.example.loginpage.data.User
import com.example.loginpage.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.fragment_sign_up.view.*

class SignUp : Fragment() {

    lateinit var userViewModel: UserViewModel
    lateinit var userNameEditText:EditText
    lateinit var emailEditText:EditText
    lateinit var passwordEditText:EditText
    lateinit var registerButton:Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding =  FragmentSignUpBinding.inflate(inflater,container,false)
         userNameEditText = binding.usernameEdittext
         emailEditText = binding.emailEdittext
         passwordEditText = binding.passwordEdittext
         registerButton = binding.registerButton

        userViewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)
        val activity: MainActivity = activity as MainActivity
        registerButton.setOnClickListener {



            val user = User(userNameEditText.text.toString(),emailEditText.text.toString(),passwordEditText.text.toString())
            if (!emptyValidation())
            {
                AsyncTask.execute{
                    userViewModel.insertUser(user)
                }

                view?.findNavController()?.navigate(R.id.action_signUp_to_login)
                Toast.makeText(activity,user.userName +" registered",Toast.LENGTH_LONG).show()
            }
            else
            {
                Toast.makeText(activity," fill empty",Toast.LENGTH_LONG).show()
            }

        }
            return binding.root
        }

    private fun emptyValidation():Boolean
    {
        if (TextUtils.isEmpty(userNameEditText.text.toString())|| TextUtils.isEmpty(passwordEditText.text.toString())||
                TextUtils.isEmpty(emailEditText.text.toString()))
        {
            return true
        }
        return false
    }

}
