package com.example.afiyahospital


import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.afiyahospital.Utilits.DEFAULT_VALUE_SHARED_PREF
import com.example.afiyahospital.Utilits.InjectorUtils
import com.example.afiyahospital.Utilits.SHARED_PREFERENCE_FILE
import com.example.afiyahospital.Utilits.TOKEN_KEY
import com.example.afiyahospital.adapter.HospitalAdapter
import com.example.afiyahospital.databinding.FragmentCreateHospitalBinding
import com.example.afiyahospital.network.NetworkHospital
import com.example.afiyahospital.viewmodel.StaffViewModel
import com.example.loginpage.HospitalPageDirections
import com.example.loginpage.viewmodel.HospitalViewModel
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_create_hospital.*
import kotlinx.android.synthetic.main.list_item_hospital.*


class CreateHospital : Fragment() {
    private val viewModel: StaffViewModel by  viewModels{
        InjectorUtils.provideStaffViewModelFactory(requireContext())
    }

    lateinit var hospitalName:EditText
    lateinit var hospitalOwendBy:EditText
    lateinit var hospitalPhoneNumber:EditText
    lateinit var hospitalRelativeAdress:EditText
    lateinit var hospitalLong:EditText
    lateinit var hospitalLat:EditText
    lateinit var sharedPref: SharedPreferences
    private lateinit var token: String
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        hospitalName = hname
        hospitalOwendBy = text2
        hospitalPhoneNumber = text3
        hospitalRelativeAdress = text4
        hospitalLat = text5
        hospitalLat = text6
        sharedPref = requireActivity().getSharedPreferences(SHARED_PREFERENCE_FILE, Context.MODE_PRIVATE)
        token = """Bearer ${sharedPref.getString(TOKEN_KEY, DEFAULT_VALUE_SHARED_PREF)}"""
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
     val binding = FragmentCreateHospitalBinding.inflate(inflater,container,false)
        binding.addHospital= onAddHospital()
        subscribeUi()

        return binding.root
    }
    private fun onAddHospital():View.OnClickListener{
        return View.OnClickListener {
            viewModel.createHospital(readFields(),token)
            Log.d("token",token)
        }

    }

    private fun readFields():NetworkHospital{
        return NetworkHospital(id = 1,
            hname = hospitalName.text.toString(),
            phoneNumbe = hospitalPhoneNumber.text.toString(),
            relativeAdress = hospitalRelativeAdress.text.toString(),
            longtuide = hospitalRelativeAdress.text.toString(),
            latitude = hospitalLat.text.toString(),
            owendby = hospitalOwendBy.text.toString(),
            image = ".jpg",
            user = ""
        )
    }
    private fun subscribeUi() {
        viewModel.hospital.observe(viewLifecycleOwner) {hospitals->

                val direction= CreateHospitalDirections.actionCreateHospitalToOneHospital2(hospitals.id)
                findNavController().navigate(direction)


        }
    }


}
