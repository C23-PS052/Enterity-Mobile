package com.bangkit.enterity.ui.main.fragment.product

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bangkit.enterity.R
import com.bangkit.enterity.databinding.FragmentProductBinding
import com.bangkit.enterity.model.Platform
import com.bangkit.enterity.ui.main.fragment.home.adapter.HomePlatformAdapter
import com.bangkit.enterity.ui.main.fragment.home.adapter.HomeProductAdapter


class ProductFragment : Fragment() {

    private lateinit var binding : FragmentProductBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductBinding.inflate(layoutInflater)

        val listFilter = listOf(
            Platform("Semua",R.drawable.all),
            Platform("Shopee",R.drawable.shopee),
            Platform("Tokopedia",R.drawable.tokped),
            Platform("Tokopedia",R.drawable.tokped),
            Platform("Tokopedia",R.drawable.tokped),
            Platform("Tokopedia",R.drawable.tokped),
            Platform("Tokopedia",R.drawable.tokped),
            Platform("Tokopedia",R.drawable.tokped),
            Platform("Tokopedia",R.drawable.tokped)
        )

        val listFilterr = listOf(
            Platform("Semua",R.drawable.all),
            Platform("Shopee",R.drawable.shopee),
            Platform("Tokopedia",R.drawable.tokped),
        )

        setFilter(listFilterr)

        setProduct(listFilter)

        return binding.root
    }

    private fun setFilter(list: List<Platform>) {
        val adapterr = HomePlatformAdapter(requireContext(),list)
        binding.rvPlatform.apply {
            layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
            adapter = adapterr
        }
    }

    private fun setProduct(list: List<Platform>) {

        val adapterr = HomeProductAdapter(requireContext(),list)
        binding.rvProduct.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
            adapter = adapterr

            addItemDecoration(
                DividerItemDecoration(
                    context,
                    DividerItemDecoration.VERTICAL
                )
            )
        }
    }

}