package com.bangkit.enterity.ui.main.fragment.customer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bangkit.enterity.R
import com.bangkit.enterity.databinding.FragmentCustomerBinding
import com.bangkit.enterity.model.Platform
import com.bangkit.enterity.ui.main.fragment.home.adapter.HomeProductAdapter


class CustomerFragment : Fragment() {


    private lateinit var binding : FragmentCustomerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCustomerBinding.inflate(layoutInflater)

        val listFilter = listOf(
            Platform("Semua", R.drawable.all),
            Platform("Shopee", R.drawable.shopee),
            Platform("Tokopedia", R.drawable.tokped),
            Platform("Tokopedia", R.drawable.tokped),
            Platform("Tokopedia", R.drawable.tokped),
            Platform("Tokopedia", R.drawable.tokped),
            Platform("Tokopedia", R.drawable.tokped),
            Platform("Tokopedia", R.drawable.tokped),
            Platform("Tokopedia", R.drawable.tokped)
        )

        setProduct(listFilter)


        return binding.root
    }

    private fun setProduct(list: List<Platform>) {

        val adapterr = CustomerAdapter(requireContext(),list)
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