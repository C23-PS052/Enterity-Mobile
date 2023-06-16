package com.bangkit.enterity.ui.main.fragment.product

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bangkit.enterity.R
import com.bangkit.enterity.databinding.FragmentProductBinding
import com.bangkit.enterity.di.Injectable
import com.bangkit.enterity.model.Platform
import com.bangkit.enterity.model.ResultCustom
import com.bangkit.enterity.ui.main.MainViewModel
import com.bangkit.enterity.ui.main.fragment.home.adapter.HomePlatformAdapter
import com.bangkit.enterity.ui.main.fragment.home.adapter.HomeProductAdapter
import javax.inject.Inject


class ProductFragment : Fragment(), Injectable {

    private lateinit var binding : FragmentProductBinding
    @Inject
    lateinit var viewModel: MainViewModel

    lateinit var adapterr : ProductAdapter

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//    }

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


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pref = context?.let { PreferenceManager.getDefaultSharedPreferences(it) }
        val token = pref?.getString(context?.getString(R.string.token), "")
        viewModel.getAllProduct("Bearer $token").observe(viewLifecycleOwner){ result ->
            when(result){
                is ResultCustom.Loading ->{
                    binding.prgBar.visibility = View.VISIBLE
                }
                is ResultCustom.Error -> {
                    binding.prgBar.visibility = View.GONE
                }
                is ResultCustom.Success -> {
//                    Toast.makeText(context, "Berhasil", Toast.LENGTH_SHORT).show()
                    binding.prgBar.visibility = View.GONE
                    adapterr.submitList(result.data.data)
                }
            }


        }
    }

    private fun setFilter(list: List<Platform>) {
        val adapterr = HomePlatformAdapter(requireContext(),list)
        binding.rvPlatform.apply {
            layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
            adapter = adapterr
        }
    }

    private fun setProduct(list: List<Platform>) {
         adapterr = ProductAdapter(requireContext())
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