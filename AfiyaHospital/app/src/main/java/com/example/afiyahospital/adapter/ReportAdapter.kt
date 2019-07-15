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
import com.example.afiyahospital.data.Report
import com.example.afiyahospital.databinding.ListItemAppointBinding
import com.example.afiyahospital.databinding.ListItemReportBinding

class ReportAdapter : ListAdapter<Report, ReportAdapter.ViewHolder>(ReportDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
        ListItemReportBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val report =getItem(position)
        holder.apply {
            itemView.tag = report
        }
    }

    class ViewHolder(
        private val binding: ListItemReportBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(listener: View.OnClickListener, item: Report) {
            with(binding) {
                report = item
                executePendingBindings()
            }
        }
    }

}





private class ReportDiffCallback : DiffUtil.ItemCallback<Report>() {
    override fun areItemsTheSame(oldItem: Report, newItem: Report): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Report, newItem :Report): Boolean {
        return oldItem.id == newItem.id
    }
}
