package com.example.afiyahospital.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.afiyahospital.SetAppointmnetFragmentDirections
import com.example.afiyahospital.data.Card
import com.example.afiyahospital.data.Hospital
import com.example.afiyahospital.databinding.ListItemAppointBinding
import com.example.afiyahospital.databinding.ListItemHospitalBinding
import com.example.loginpage.HospitalPageDirections

class CardAdapter: ListAdapter<Card, CardAdapter.ViewHolder>(CardDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
        ListItemAppointBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val card =getItem(position)
        holder.apply {
            bind(createOnClickListener(card.cardNo),card)
            itemView.tag = card
        }
    }
    private fun createOnClickListener(cno:String): View.OnClickListener{
        return View.OnClickListener {
            val direction: NavDirections = SetAppointmnetFragmentDirections.actionSetAppointmnetFragmentToDetailAppoint(cno)
            it.findNavController().navigate(direction)
        }
    }


    class ViewHolder(
        private val binding: ListItemAppointBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(listener: View.OnClickListener, item: Card) {
            with(binding) {
                clickListener = listener
                card = item

                executePendingBindings()
            }
        }
    }
}


private class CardDiffCallback : DiffUtil.ItemCallback<Card>() {
    override fun areItemsTheSame(oldItem: Card, newItem: Card): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Card, newItem: Card): Boolean {
        return oldItem.id == newItem.id
    }

}