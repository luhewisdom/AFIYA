package com.example.afiyahospital


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.example.afiyahospital.databinding.FragmentHospitalBinding
import com.example.afiyahospital.databinding.FragmentOneHospitalBinding
import com.example.loginpage.viewmodel.HospitalViewModel


class OneHospital : Fragment() {
    private lateinit var  viewmodel:HospitalViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding   = FragmentOneHospitalBinding.inflate(inflater,container,false)
        context ?: return binding.root
        binding.setLifecycleOwner(this)


        return binding.root
    }


}
