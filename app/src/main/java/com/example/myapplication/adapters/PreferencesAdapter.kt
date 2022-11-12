package com.example.myapplication.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.databinding.ItemPreferenceBinding
import com.example.myapplication.global_objects.Constants
import com.example.myapplication.ingterfaces.TagPositionInterface

class PreferencesAdapter(private val clickInterface: TagPositionInterface) :
    RecyclerView.Adapter<PreferencesAdapter.ViewHolder>() {
    private val prefList = mutableListOf<Pair<Int, Int>>()

    init {
        prefList.apply {
            add(Pair(R.drawable.vec_manage, R.string.acc_info))
            add(Pair(R.drawable.vec_persons, R.string.change_student))
            add(Pair(R.drawable.vec_notification_prefs, R.string.notification_prefs))
            add(Pair(R.drawable.vec_track_location, R.string.track_location))
            add(Pair(R.drawable.vec_help, R.string.help))
            add(Pair(R.drawable.vec_logout, R.string.log_out))
        }
    }


    inner class ViewHolder(private val binding: ItemPreferenceBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                clickInterface.onClick(Constants.PREFERENCE, adapterPosition)
            }
        }

        fun bind(pref: Pair<Int, Int>) {
            binding.apply {
                settingImg.setImageResource(pref.first)
                settingTxt.setText(pref.second)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemPreferenceBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(prefList[position])
    }

    override fun getItemCount() = prefList.size
}