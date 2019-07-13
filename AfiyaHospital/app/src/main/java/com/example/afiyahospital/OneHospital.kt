package com.example.afiyahospital


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.navArgs
import com.example.afiyahospital.Utilits.InjectorUtils
import com.example.afiyahospital.databinding.FragmentHospitalBinding
import com.example.afiyahospital.databinding.FragmentOneHospitalBinding
import com.example.afiyahospital.viewmodel.HospitalDetailViewModel
import com.example.loginpage.viewmodel.HospitalViewModel


class OneHospital : Fragment() {

    private val args:OneHospitalArgs by navArgs()
    private val hospitalDetailViewModel:HospitalDetailViewModel by viewModels{
        InjectorUtils.provideHospitalDetailViewModel(requireContext(),args.id)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding   = FragmentOneHospitalBinding.inflate(inflater,container,false)
        context ?: return binding.root
        binding.setLifecycleOwner(this)
        binding.oneHospitalViewModel = hospitalDetailViewModel
        return binding.root
    }


}
