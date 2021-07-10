package com.ddev.ecommerceapp.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ddev.ecommerceapp.view.VapesFragment
import com.ddev.ecommerceapp.view.ExploreFragment
import com.ddev.ecommerceapp.view.FlowersFragment

class ItemAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle):
    FragmentStateAdapter(fragmentManager,lifecycle) {

    override fun getItemCount(): Int {
        return 5
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> FlowersFragment()
            1 -> FlowersFragment()
            2 -> FlowersFragment()
            3 -> FlowersFragment()
            4 -> FlowersFragment()
            else -> FlowersFragment()
        }
    }

}