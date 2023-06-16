package com.bangkit.enterity.ui.main.fragment.home.ViewHolder

import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bangkit.enterity.R
import com.bangkit.enterity.databinding.HomeDataBinding
import com.bangkit.enterity.model.Platform
import com.bangkit.enterity.model.ResultCustom
import com.bangkit.enterity.ui.main.MainViewModel
import com.bangkit.enterity.ui.main.fragment.home.adapter.HomePlatformAdapter
import com.bangkit.enterity.ui.main.fragment.home.adapter.HomeProductAdapter
import javax.inject.Inject


class HomeData(
    private val binding: HomeDataBinding,
    private val lifecycle: LifecycleOwner
    ) : HomeViewHolder (binding.root) {

    @Inject
    lateinit var viewModel: MainViewModel

    private  var context: Context = binding.root.context
    private lateinit var adapterr : HomeProductAdapter


    override fun bind(context: Context, viewModel: MainViewModel, parent: Fragment) {

        val pref = PreferenceManager.getDefaultSharedPreferences(context)
        val token = pref.getString(context.getString(R.string.token), "")
        Log.d(TAG, "bindtoken: $token")

        val listFilter = listOf(
            Platform("Semua",R.drawable.all),
            Platform("Shopee",R.drawable.shopee),
            Platform("Tokopedia",R.drawable.tokped)
        )

        setProduct(listFilter)

        viewModel.getAllProductChannel("Bearer $token").observe(lifecycle){ result ->
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


        setFilter(listFilter)


    }

    private fun setFilter(list: List<Platform>) {
        val adapterr = HomePlatformAdapter(context,list)
        binding.rvPlatform.apply {
            layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
            adapter = adapterr
        }
    }
    private fun setProduct(list: List<Platform>) {

         adapterr = HomeProductAdapter(context)
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