package com.example.loginpage


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.afiyahospital.R
import com.example.afiyahospital.Utilits.InjectorUtils

import com.example.afiyahospital.adapter.HospitalAdapter
import com.example.afiyahospital.databinding.FragmentHospitalBinding
import com.example.afiyahospital.viewmodel.HospitalViewModelFactory
import com.example.loginpage.viewmodel.HospitalViewModel
import kotlinx.android.synthetic.main.fragment_hospital.view.*
import kotlinx.coroutines.flow.BehaviourSubject


class HospitalPage : Fragment() {

    private val viewModel:HospitalViewModel by  viewModels{
        InjectorUtils.provideHositalViewModelFactory(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding:FragmentHospitalBinding  = FragmentHospitalBinding.inflate(inflater,container,false)
        context ?: return binding.root

        binding.setLifecycleOwner(viewLifecycleOwner)

        val adaptere = HospitalAdapter()
        binding.hospitalList.adapter = adaptere
        subscribeUi(adaptere)
        viewModel.eventNetworkError.observe(this, Observer<Boolean> { isNetworkError ->
            if (isNetworkError) onNetworkError()
        })
        return binding.root
    }
    private fun subscribeUi(adapter: HospitalAdapter) {
            viewModel.hospitals.observe(viewLifecycleOwner) {hospitals->

             adapter.submitList(hospitals)
        }
    }

    private fun onNetworkError() {
        if(!viewModel.isNetworkErrorShown.value!!) {
            Toast.makeText(activity, "Network Error", Toast.LENGTH_LONG).show()
            viewModel.onNetworkErrorShown()
        }
    }
}