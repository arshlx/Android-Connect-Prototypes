package com.example.myapplication.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemAssignmentBinding
import com.example.myapplication.model.Assignment

class AssignmentAdapter(private val assignmentList: MutableList<Assignment>) :
    RecyclerView.Adapter<AssignmentAdapter.AssignmentViewHolder>() {

    inner class AssignmentViewHolder(private val binding: ItemAssignmentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {

        }

        fun bind(assn: Assignment) {
            binding.apply {
                assnNameTxt.text = assn.name
                dueDateTxt.text = assn.dueDate
                descriptionTxt.text = assn.desc
                groupImg.isVisible = assn.isGroup
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AssignmentViewHolder {
        return AssignmentViewHolder(
            ItemAssignmentBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: AssignmentViewHolder, position: Int) {
        holder.bind(assignmentList[position])
    }

    override fun getItemCount() = assignmentList.size
}