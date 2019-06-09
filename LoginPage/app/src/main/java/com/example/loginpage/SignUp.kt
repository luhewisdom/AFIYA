package com.example.loginpage


import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.get
import com.example.loginpage.data.User
import com.example.loginpage.viewmodel.AfiaViewModel
import kotlinx.android.synthetic.main.fragment_sign_up.*
import kotlinx.android.synthetic.main.fragment_sign_up.view.*

class SignUp : Fragment() {

    lateinit var afiaViewModel: AfiaViewModel

    private lateinit var listener:OnRegisteredButtonClicked

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if(context is OnRegisteredButtonClicked)
        {
            listener = context
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sign_up, container, false)
        val userNameEditText = view.username_edittext
        val emailEditText = view.email_edittext
        val  passwordEditText = view.password_edittext
        val  registerButton = view.register_button

        afiaViewModel = ViewModelProviders.of(this).get(AfiaViewModel::class.java)
        val activity:MainActivity = activity as MainActivity
        registerButton.setOnClickListener {
            val user = User(userNameEditText.text.toString(),emailEditText.text.toString(),passwordEditText.text.toString())

            AsyncTask.execute{
                afiaViewModel.insertUser(user)
            }
            Toast.makeText(activity,user.userName +" registered",Toast.LENGTH_LONG).show()
            listener.onRegisteredClicked(user)


        }
        return view
    }


    interface OnRegisteredButtonClicked
    {
        fun onRegisteredClicked(user:User)
    }
}
