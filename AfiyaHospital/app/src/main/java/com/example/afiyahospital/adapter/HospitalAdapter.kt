package com.example.afiyahospital.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.afiyahospital.data.Hospital
import com.example.afiyahospital.databinding.FragmentHospitalBinding
import com.example.afiyahospital.databinding.ListItemHospitalBinding
import com.example.loginpage.HospitalPageDirections
import com.example.loginpage.viewmodel.HospitalViewModel


class HospitalAdapter: ListAdapter<Hospital, HospitalAdapter.ViewHolder>(HospitalDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       return ViewHolder(ListItemHospitalBinding.inflate(LayoutInflater.from(parent.context),
           parent,false))

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val hospital =getItem(position)
        holder.apply {
            bind(createOnClickListener(hospital.id),hospital)
            itemView.tag = hospital
        }
    }
    private fun createOnClickListener(hospitalId:Long):View.OnClickListener{
        return View.OnClickListener { val direction:NavDirections =
            HospitalPageDirections.actionHospitalPage2ToOneHospital(hospitalId)
            it.findNavController().navigate(direction)
        }
    }


    class ViewHolder(
        private val binding: ListItemHospitalBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(listener: View.OnClickListener, item: Hospital) {
            with(binding) {
                clickListener = listener
                hospital = item

                executePendingBindings()
            }
        }
    }
}


private class HospitalDiffCallback : DiffUtil.ItemCallback<Hospital>() {
    override fun areContentsTheSame(oldItem: Hospital, newItem: Hospital): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areItemsTheSame(oldItem: Hospital, newItem: Hospital): Boolean {
        return oldItem == newItem
    }
}