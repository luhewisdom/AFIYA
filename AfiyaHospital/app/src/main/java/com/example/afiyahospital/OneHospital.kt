package com.example.afiyahospital


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.example.afiyahospital.databinding.FragmentHospitalBinding
import com.example.loginpage.viewmodel.HospitalViewModel


class OneHospital : Fragment() {
    private lateinit var  viewmodel:HospitalViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding   = FragmentHospitalBinding.inflate(inflater,container,false)
        context ?: return binding.root
        viewmodel = ViewModelProviders.of(this).get(HospitalViewModel::class.java)

        binding.hospitalViewModel  = viewmodel
        binding.setLifecycleOwner(this)


        return binding.root
    }


}
