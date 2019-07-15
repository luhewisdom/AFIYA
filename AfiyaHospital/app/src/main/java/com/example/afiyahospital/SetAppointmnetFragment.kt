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
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.afiyahospital.Utilits.*
import com.example.afiyahospital.adapter.CardAdapter
import com.example.afiyahospital.adapter.HospitalAdapter
import com.example.afiyahospital.data.Card
import com.example.afiyahospital.databinding.FragmentHospitalBinding
import com.example.afiyahospital.databinding.FragmentSetAppointmnetBinding
import com.example.afiyahospital.viewmodel.CardViewModel
import com.example.loginpage.viewmodel.HospitalViewModel


class SetAppointmnetFragment : Fragment() {
    lateinit var sharedPrefrence: SharedPreferences
    private  lateinit var token:String


    override fun onAttach(context: Context) {
        super.onAttach(context)
        sharedPrefrence =  requireActivity().getSharedPreferences(SHARED_PREFERENCE_FILE, Context.MODE_PRIVATE)
        token = """Bearer ${sharedPrefrence.getString(TOKEN_KEY, DEFAULT_VALUE_SHARED_PREF)}"""
    }


    private val viewModel: CardViewModel by  viewModels{
        InjectorUtils.provideCardViewModelFactory(requireContext())
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSetAppointmnetBinding.inflate(inflater,container,false)

        context ?: return binding.root
        binding.setLifecycleOwner(this)
        val adapter = CardAdapter()
        binding.appointList.adapter = adapter
        binding.fab = fab()
        getAppoint(token)
        subscribeUi(adapter)
        return binding.root
    }

    private fun subscribeUi(adapter: CardAdapter) {
        viewModel.cards.observe(viewLifecycleOwner) {card->
            adapter.submitList(card)
        }

    }

    private fun getAppoint(t:String)
    {
        viewModel.refershCardFromRepository(t)
    }

    private fun fab():View.OnClickListener {
        return View.OnClickListener {
            requireView().findNavController().navigate(R.id.addAppointment)
        }
    }

}
