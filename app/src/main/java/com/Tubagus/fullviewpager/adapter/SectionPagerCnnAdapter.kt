package com.Tubagus.fullviewpager.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.Tubagus.fullviewpager.ui.detailCnn.CnnInternasionalFragment
import com.Tubagus.fullviewpager.ui.detailCnn.CnnNasionalFragment
import com.Tubagus.fullviewpager.ui.detailCnn.CnnTerbaruFragment

class SectionPagerCnnAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> CnnTerbaruFragment()
            1 -> CnnNasionalFragment()
            2 -> CnnInternasionalFragment()
            else -> CnnTerbaruFragment()
        }
    }
}