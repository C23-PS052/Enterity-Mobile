package com.bangkit.enterity.ui.main.fragment.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.enterity.databinding.ItemPlatformBinding
import com.bangkit.enterity.databinding.ItemProductBinding
import com.bangkit.enterity.model.Platform

class HomeProductAdapter (
    private val context: Context,
    val list : List<Platform>
)  : RecyclerView.Adapter<HomeProductAdapter.ViewHolder>() {

    private var selectedItemPosition: Int = 0


    inner  class ViewHolder(private var binding : ItemProductBinding) : RecyclerView.ViewHolder(binding.root){
        private var itemPosition: Int = 0
        private val container = binding.root
        fun bind(card : Platform){



        }


    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeProductAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemCardEksplorBinding = ItemProductBinding.inflate(layoutInflater,parent,false)
        return ViewHolder(itemCardEksplorBinding)
    }

    override fun onBindViewHolder(holder: HomeProductAdapter.ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}