package com.example.dropview.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter(fragmentManager: FragmentManager,
    private val fragments: MutableList<Pair<String, Fragment>> = mutableListOf()
) : FragmentPagerAdapter(fragmentManager) {

    override fun getItem(position: Int) = fragments[position].second

    override fun getCount() = fragments.size

    override fun getPageTitle(position: Int) = fragments[position].first

    fun addFragment(pair: Pair<String, Fragment>) {
        fragments.add(pair)
        notifyDataSetChanged()
    }
}