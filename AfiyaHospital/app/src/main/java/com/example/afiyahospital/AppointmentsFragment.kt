package com.example.afiyahospital


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.afiyahospital.databinding.FragmentAppointmentsBinding
import kotlinx.android.synthetic.main.fragment_appointments.*


class AppointmentsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      val binding = FragmentAppointmentsBinding.inflate(inflater,container,false)
        binding.setLifecycleOwner(this)
        binding.fab = fab()

        return binding.root
    }
    private fun fab():View.OnClickListener{
      return View.OnClickListener {
          requireView().findNavController().navigate(R.id.createHospital)
      }

    }


}
