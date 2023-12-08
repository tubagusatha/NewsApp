package com.Tubagus.fullviewpager.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.Tubagus.fullviewpager.adapter.SectionPagerCnnAdapter
import com.Tubagus.fullviewpager.data.repository.NewsRepository
import com.Tubagus.fullviewpager.ui.NewsViewModel
import com.Tubagus.fullviewpager.utils.NewsViewModelFactory
import com.Tubagus.fullviewpager.databinding.FragmentCnnBinding
import com.google.android.material.tabs.TabLayoutMediator

class CnnFragment : Fragment() {
    lateinit var  binding: FragmentCnnBinding
    private val cnnViewModel: NewsViewModel by viewModels {
        NewsViewModelFactory(NewsRepository())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCnnBinding.inflate(layoutInflater)
        setUpViewPager()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    private fun setUpViewPager() {
        val tabList = arrayOf(
            "Terbaru",
            "Nasional",
            "Internasional",
        )

        val sectionPagerAdapter = SectionPagerCnnAdapter(requireActivity())
        binding.vpNews.adapter = sectionPagerAdapter

        TabLayoutMediator(binding.tabs, binding.vpNews) { tab, page ->
            tab.text = tabList[page]
        }.attach()
    }

}