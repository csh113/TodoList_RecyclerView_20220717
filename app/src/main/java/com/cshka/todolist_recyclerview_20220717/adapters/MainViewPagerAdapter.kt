package com.cshka.todolist_20220717.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.cshka.todolist_20220717.fragments.TodoFragment
import com.cshka.todolist_20220717.fragments.GoalFragment
import com.cshka.todolist_20220717.fragments.SettingFragment

class MainViewPagerAdapter(fa : FragmentActivity) : FragmentStateAdapter(fa) {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> return TodoFragment()
            1 -> return GoalFragment()
            else -> return SettingFragment()
        }
    }

}