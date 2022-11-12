package com.example.myapplication.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myapplication.ingterfaces.PositionInterface
import com.example.myapplication.global_objects.Constants.NAV_ASSIGNMENTS
import com.example.myapplication.global_objects.Constants.NAV_DISCUSSION
import com.example.myapplication.global_objects.Constants.NAV_NUM_TOTAL
import com.example.myapplication.global_objects.Constants.NAV_OVERVIEW
import com.example.myapplication.global_objects.Constants.NAV_PREFERENCES
import com.example.myapplication.main.AssignmentsFragment
import com.example.myapplication.main.DiscussionFragment
import com.example.myapplication.main.OverviewFragment
import com.example.myapplication.main.PreferencesFragment

class FragmentPagerAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
    private val listener: PositionInterface
) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount() = NAV_NUM_TOTAL

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            NAV_OVERVIEW -> {
                listener.onPositionChanged(NAV_OVERVIEW)
                OverviewFragment.newInstance()
            }
            NAV_ASSIGNMENTS -> {
                listener.onPositionChanged(NAV_ASSIGNMENTS)
                AssignmentsFragment.newInstance()
            }
            NAV_DISCUSSION -> {
                listener.onPositionChanged(NAV_DISCUSSION)
                DiscussionFragment.newInstance()
            }
            else -> {
                listener.onPositionChanged(NAV_PREFERENCES)
                PreferencesFragment.newInstance()
            }
        }
    }

}