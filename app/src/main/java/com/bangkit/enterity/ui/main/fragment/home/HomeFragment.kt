package com.bangkit.enterity.ui.main.fragment.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.bangkit.enterity.R
import com.bangkit.enterity.databinding.FragmentHomeBinding
import com.bangkit.enterity.databinding.HomeDataBinding
import com.bangkit.enterity.databinding.HomeTopBinding
import com.bangkit.enterity.di.Injectable
import com.bangkit.enterity.ui.main.fragment.home.ViewHolder.HomeData
import com.bangkit.enterity.ui.main.fragment.home.ViewHolder.HomeTop
import com.bangkit.enterity.ui.main.fragment.home.ViewHolder.HomeViewHolder
import com.bangkit.enterity.ui.main.fragment.home.adapter.HomeViewAdapter
import javax.inject.Inject


class HomeFragment : Fragment(),Injectable {

    private lateinit var binding : FragmentHomeBinding

    private var listHomeViews = mutableListOf<HomeViewHolder>()

    @Inject
    lateinit var viewModel: HomeViewModel



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            listHomeViews = mutableListOf(
                HomeTop(
                    HomeTopBinding.inflate(LayoutInflater.from(requireContext()),this.root,false)
                ),
                HomeData(
                    HomeDataBinding.inflate(LayoutInflater.from(requireContext()),this.root,false)
                ),
            )

            rvHome.setHasFixedSize(true)
            rvHome.layoutManager = LinearLayoutManager(requireContext())
            rvHome.adapter = HomeViewAdapter(listHomeViews, viewModel, this@HomeFragment)

        }


    }
}