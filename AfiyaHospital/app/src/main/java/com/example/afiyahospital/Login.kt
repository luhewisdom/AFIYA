package com.example.loginpage


import android.content.Context
import android.content.SharedPreferences
import android.os.AsyncTask
import android.os.Build
import android.os.Bundle
import android.os.Looper
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.afiyahospital.R
import com.example.afiyahospital.Utilits.AuthenticationState
import com.example.afiyahospital.Utilits.InjectorUtils
import com.example.afiyahospital.Utilits.SHARED_PREFERENCE_FILE
import com.example.afiyahospital.Utilits.SharedPrefUtil
import com.example.afiyahospital.databinding.FragmentLoginBinding
import com.example.afiyahospital.viewmodel.LoginViewModel
import com.example.loginpage.viewmodel.UserViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_login.view.*



class Login : Fragment() {

    private lateinit var  usernameEditText:EditText
    private lateinit var passwordEditText : EditText

    lateinit var sharedPrefrence:SharedPreferences
    private val loginViewModel:LoginViewModel by viewModels{
        InjectorUtils.provideLoginViewModelFactory(requireContext())
    }

    var userOne:Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPrefrence  = requireActivity().getSharedPreferences(SHARED_PREFERENCE_FILE,Context.MODE_PRIVATE)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val binding :FragmentLoginBinding = DataBindingUtil.inflate(
            inflater,R.layout.fragment_login,container,false
        )
        binding.setLifecycleOwner(viewLifecycleOwner)

        usernameEditText = binding.usernameId
        passwordEditText = binding.passId
        val loginButton = binding.loginbuttonId
        val signupButton = binding.signupbuttonId



        signupButton.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_login_to_signUp)

        }
        loginButton.setOnClickListener {
            login()
            emptyValidation()
            clearFields()

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

    private fun login(){

            val job = loginViewModel.login(usernameEditText.text.toString(),passwordEditText.text.toString())
            subscribeLoginResponse()
            subscribeAuthenticationState()

    }


    private fun subscribeLoginResponse(){
        loginViewModel.loginResponse.observe(this, Observer {res->
            if(res.isSuccessful){

                SharedPrefUtil.savePreference(sharedPrefrence,res.body()!!.token,res.body()!!.username,res.body()!!.role)
                Log.d("string",res.body()!!.token)
                //set authentication state
                loginViewModel.acceptAuthentication()
                successLogin(res.body()!!.role)
            }
            else{
                loginViewModel.refuseAuthentication()
            } })
    }
    private fun subscribeAuthenticationState(){
        loginViewModel.autententicationState.observe(viewLifecycleOwner, Observer { authenticationState ->
            when (authenticationState) {
                AuthenticationState.AUTHENTICATED -> findNavController().popBackStack()
            }
        })
    }

    private fun clearFields(){
        usernameEditText.setText("")
        passwordEditText.setText("")
    }

    fun successLogin( role:String) {
        if(role == "STAFF")
        {
            requireView().findNavController().navigate(R.id.appointmentsFragment)

        }
        else if (role =="SUPER")
        {
            requireView().findNavController().navigate(R.id.superFragment)
        }
        else if (role == "client")
        {
            requireView().findNavController().navigate(R.id.hospitalPage)
        }
        else{
            requireView().findNavController().navigate(R.id.login)
        }

    }
}