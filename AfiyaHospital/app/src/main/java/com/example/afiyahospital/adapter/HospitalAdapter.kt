package com.example.afiyahospital.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.library.baseAdapters.BR.hospital
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.afiyahospital.databinding.ListItemHospitalBinding
import com.example.loginpage.data.Hospital

class HospitalAdapter: ListAdapter<Hospital, HospitalAdapter.ViewHolder>(HospitalDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       return ViewHolder(ListItemHospitalBinding.inflate(LayoutInflater.from(parent.context),
           parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val hospital =getItem(position)

    }


    class ViewHolder(
        private val binding: ListItemHospitalBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(listener: View.OnClickListener, item: Hospital) {
            binding.apply {
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