package com.example.myapplication.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemDueAssignmentBinding
import com.example.myapplication.model.Assignment

class DueAssignmentsAdapter(private val dueAssnList: List<Assignment>) :
    RecyclerView.Adapter<DueAssignmentsAdapter.DueAssignmentViewHolder>() {

    inner class DueAssignmentViewHolder(private val binding: ItemDueAssignmentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(assignment: Assignment) {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DueAssignmentViewHolder {
        return DueAssignmentViewHolder(
            ItemDueAssignmentBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: DueAssignmentViewHolder, position: Int) {
        holder.bind(dueAssnList[position])
    }

    override fun getItemCount() = dueAssnList.size
}