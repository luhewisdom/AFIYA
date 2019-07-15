package com.example.afiyahospital


import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.example.afiyahospital.Utilits.DEFAULT_VALUE_SHARED_PREF
import com.example.afiyahospital.Utilits.InjectorUtils
import com.example.afiyahospital.Utilits.SHARED_PREFERENCE_FILE
import com.example.afiyahospital.Utilits.TOKEN_KEY
import com.example.afiyahospital.adapter.CardAdapter
import com.example.afiyahospital.adapter.HospitalAdapter
import com.example.afiyahospital.adapter.ReportAdapter
import com.example.afiyahospital.databinding.FragmentCheckReportBinding
import com.example.afiyahospital.viewmodel.CardViewModel
import com.example.afiyahospital.viewmodel.ReportViewModel
import com.example.loginpage.viewmodel.HospitalViewModel


class CheckReport : Fragment() {
    lateinit var sharedPrefrence: SharedPreferences
    private  lateinit var token:String

    private val viewModel: CardViewModel by  viewModels{
        InjectorUtils.provideCardViewModelFactory(requireContext())
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        sharedPrefrence =  requireActivity().getSharedPreferences(SHARED_PREFERENCE_FILE, Context.MODE_PRIVATE)
        token = """Bearer ${sharedPrefrence.getString(TOKEN_KEY, DEFAULT_VALUE_SHARED_PREF)}"""
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentCheckReportBinding.inflate(inflater,container,false)
        context ?: return binding.root
        binding.setLifecycleOwner(this)
        val adapter = ReportAdapter()
        binding.reportList.adapter = adapter
        getReport(token)
        subscribeUi(adapter)
        return binding.root
    }
    private fun subscribeUi(adapter: ReportAdapter) {
        viewModel.reports.observe(viewLifecycleOwner) {reports->

            adapter.submitList(reports)
        }
    }
    private fun getReport(t:String)
    {
        viewModel.refershReportFromRepository(t)
    }
}
