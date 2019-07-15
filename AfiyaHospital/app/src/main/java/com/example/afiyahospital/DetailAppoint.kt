package com.example.afiyahospital


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.afiyahospital.Utilits.InjectorUtils
import com.example.afiyahospital.databinding.FragmentDetailAppointBinding
import com.example.afiyahospital.viewmodel.CardDetailViewModel
import com.example.afiyahospital.viewmodel.HospitalDetailViewModel


class DetailAppoint : Fragment() {
    private val args:DetailAppointArgs by navArgs()
    private val cardDetailViewModel:CardDetailViewModel by viewModels{
        InjectorUtils.provideCardDetailViewModel(requireContext(),args.rno)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
            val binding = FragmentDetailAppointBinding.inflate(inflater,container,false)
        context ?: return binding.root
        binding.setLifecycleOwner(this)
        binding.oneCardViewModel = cardDetailViewModel

        return binding.root
    }
}
