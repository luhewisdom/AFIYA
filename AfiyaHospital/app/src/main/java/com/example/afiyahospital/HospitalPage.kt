package com.example.loginpage


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders

import com.example.afiyahospital.adapter.HospitalAdapter
import com.example.afiyahospital.databinding.FragmentUserPageBinding
import com.example.loginpage.viewmodel.HospitalViewModel
import com.example.loginpage.viewmodel.UserViewModel


class HospitalPage : Fragment() {

    private lateinit var  viewModel:HospitalAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentUserPageBinding.inflate(inflater,container,false)
        context ?: return binding.root
        val adapter = HospitalAdapter()
        binding.hospitalList.adapter = adapter
        return binding.root
    }
}
