package com.example.dropview.fragments

import android.os.Build
import android.os.Bundle
import android.transition.TransitionManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintSet

import com.example.dropview.R
import com.example.dropview.adapter.ViewPagerAdapter
import com.example.dropview.fragments.viewpagerfragments.FirstFragment
import com.example.dropview.fragments.viewpagerfragments.SecondFragment
import com.example.dropview.fragments.viewpagerfragments.ThirdFragment
import kotlinx.android.synthetic.main.fragment_view_pager.*

class ViewPagerFragment : Fragment() {

    private val viewPagerAdapter by lazy { ViewPagerAdapter(childFragmentManager) }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_view_pager, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupAdapter()
        addAnimationOperations()
    }

    private fun setupAdapter() {
        val adapter = viewPagerAdapter.also {
            viewPagerAdapter.addFragment("First" to FirstFragment())
            viewPagerAdapter.addFragment("Second" to SecondFragment())
            viewPagerAdapter.addFragment("Third" to ThirdFragment())
        }

        myViewPager.adapter = adapter

        myTabLayout.setupWithViewPager(myViewPager)
    }

    private fun addAnimationOperations() {
        var set = false
        val constraint1 = ConstraintSet()
        constraint1.clone(root)
        val constraint2 = ConstraintSet()
        constraint2.clone(constraint1)

        constraint2.setMargin(R.id.linear, ConstraintSet.BOTTOM, 0)

        root.setOnClickListener{
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                TransitionManager.beginDelayedTransition(root)
                val constraint = if(set) constraint1 else constraint2
                constraint.applyTo(root)
                set = !set
            }
        }
    }
}
