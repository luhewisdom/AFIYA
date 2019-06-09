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
import androidx.lifecycle.ViewModelProviders
import com.example.loginpage.data.User
import com.example.loginpage.viewmodel.AfiaViewModel
import kotlinx.android.synthetic.main.fragment_login.view.*



class Login : Fragment() {

    private lateinit var listener:OnSignUpButtonClicked
    private lateinit var caller:OnLoginButtonClicked
    private lateinit var  usernameEditText:EditText
    private lateinit var passwordEditText : EditText
    lateinit var afiaViewModel: AfiaViewModel
    var userOne:Boolean = false
    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if(context is OnSignUpButtonClicked)
        {
            listener = context
        }
        if (context is OnLoginButtonClicked)
        {
            caller = context
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view:View = inflater.inflate(R.layout.fragment_login, container, false)
        usernameEditText = view.username_id
        passwordEditText = view.pass_id
        val loginButton = view.loginbutton_id
        val signupButton = view.signupbutton_id

        afiaViewModel = ViewModelProviders.of(this).get(AfiaViewModel::class.java)
        loginButton.setOnClickListener {

           AsyncTask.execute {
                userOne= afiaViewModel.oneUser(usernameEditText.text.toString(),passwordEditText.text.toString())

           }

            if(!emptyValidation())
            {
                if(userOne == true)
                {
                    caller.onLoginClickede()
                }
                else
                {
                    Toast.makeText(activity, "Unregistered user, or incorrect", Toast.LENGTH_SHORT).show();
                }
            }
            else{
                Toast.makeText(activity, "Empty Fields", Toast.LENGTH_SHORT).show();
            }

        }

        signupButton.setOnClickListener {
             listener.onSignupclicked()
        }
        return view
    }

    interface OnSignUpButtonClicked{
        fun onSignupclicked()
    }

    interface OnLoginButtonClicked{
        fun  onLoginClickede()
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