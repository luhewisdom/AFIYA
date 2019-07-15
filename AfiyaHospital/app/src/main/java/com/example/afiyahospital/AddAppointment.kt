package com.example.afiyahospital


import android.content.ClipDescription
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
import com.example.afiyahospital.databinding.FragmentAddAppointmentBinding
import com.example.afiyahospital.network.NetworkCard
import com.example.afiyahospital.network.NetworkHospital
import com.example.afiyahospital.viewmodel.CardViewModel
import com.example.afiyahospital.viewmodel.StaffViewModel
import kotlinx.android.synthetic.main.fragment_create_hospital.*

class AddAppointment : Fragment() {
    private val viewModel: CardViewModel by  viewModels{
        InjectorUtils.provideCardViewModelFactory(requireContext())
    }
    lateinit var hospitalName: EditText
    lateinit var description: EditText
    lateinit var cardNo: EditText
    lateinit var sharedPref: SharedPreferences
    private lateinit var token: String

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        hospitalName = text3
        description = text2
        cardNo = hname
        sharedPref = requireActivity().getSharedPreferences(SHARED_PREFERENCE_FILE, Context.MODE_PRIVATE)
        token = """Bearer ${sharedPref.getString(TOKEN_KEY, DEFAULT_VALUE_SHARED_PREF)}"""
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentAddAppointmentBinding.inflate(inflater,container,false)
        binding.addHospital= onAddHospital()
        subscribeUi()
        return binding.root
    }

    private fun onAddHospital():View.OnClickListener{
        return View.OnClickListener {
            viewModel.setAppointment(readFields(),token)

            Log.d("token",token)
        }

    }

    private fun readFields(): NetworkCard{
        return NetworkCard(id =1,cardNo = cardNo.text.toString(),description = description.text.toString(),
            date = "",approved = "False",userName = "",hospitalName = hospitalName.text.toString())
    }
    private fun subscribeUi() {
        viewModel.card.observe(viewLifecycleOwner){
            card ->

            val direction= AddAppointmentDirections.actionAddAppointmentToDetailAppoint(card.cardNo)
            findNavController().navigate(direction)
        }
    }




}
