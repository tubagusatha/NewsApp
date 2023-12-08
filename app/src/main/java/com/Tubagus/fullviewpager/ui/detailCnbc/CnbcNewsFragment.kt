package com.Tubagus.fullviewpager.ui.detailCnbc

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.Tubagus.fullviewpager.adapter.NewsAdapter
import com.Tubagus.fullviewpager.data.repository.NewsRepository
import com.Tubagus.fullviewpager.ui.NewsViewModel
import com.Tubagus.fullviewpager.utils.NewsViewModelFactory
import com.Tubagus.fullviewpager.databinding.FragmentCnbcNewsBinding


class CnbcNewsFragment : Fragment() {
    lateinit var binding:FragmentCnbcNewsBinding
    private val cnbcNews: NewsViewModel by viewModels {
        NewsViewModelFactory(NewsRepository())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCnbcNewsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mAdapter = NewsAdapter()


        cnbcNews.getCnbcNews()


        cnbcNews.cnbcNews.observe(viewLifecycleOwner) { dataNews ->
            dataNews?.data?.let { mAdapter.setData(it.posts) }
        }


            binding.rvCommonNews.apply {
                adapter = mAdapter
                layoutManager = LinearLayoutManager(requireContext())
            }
        }
    }
