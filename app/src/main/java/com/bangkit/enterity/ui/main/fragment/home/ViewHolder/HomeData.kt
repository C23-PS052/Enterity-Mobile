package com.bangkit.enterity.ui.main.fragment.home.ViewHolder

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bangkit.enterity.R
import com.bangkit.enterity.databinding.HomeDataBinding
import com.bangkit.enterity.model.Platform
import com.bangkit.enterity.ui.main.fragment.home.HomeViewModel
import com.bangkit.enterity.ui.main.fragment.home.adapter.HomePlatformAdapter
import com.bangkit.enterity.ui.main.fragment.home.adapter.HomeProductAdapter


class HomeData(
    private val binding: HomeDataBinding
    ) : HomeViewHolder (binding.root)

{
    private  var context: Context = binding.root.context



    override fun bind(context: Context, viewModel: HomeViewModel, parent: Fragment) {

        val listFilter = listOf(
            Platform("Semua",R.drawable.all),
            Platform("Shopee",R.drawable.shopee),
            Platform("Tokopedia",R.drawable.tokped)
        )

        setFilter(listFilter)
        setProduct(listFilter)

    }

    private fun setFilter(list: List<Platform>) {
        val adapterr = HomePlatformAdapter(context,list)
        binding.rvPlatform.apply {
            layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
            adapter = adapterr
        }
    }
    private fun setProduct(list: List<Platform>) {

        val adapterr = HomeProductAdapter(context,list)
        binding.rvProduct.apply {
            layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
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