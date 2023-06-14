package com.bangkit.enterity.ui.main.fragment.customer

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.enterity.databinding.ItemPelangganBinding
import com.bangkit.enterity.databinding.ItemProductBinding
import com.bangkit.enterity.model.Platform
import com.bangkit.enterity.ui.main.fragment.home.adapter.HomeProductAdapter

class CustomerAdapter (
    private val context: Context,
    val list : List<Platform>
)  : RecyclerView.Adapter<CustomerAdapter.ViewHolder>() {

    private var selectedItemPosition: Int = 0


    inner  class ViewHolder(private var binding : ItemPelangganBinding) : RecyclerView.ViewHolder(binding.root){
        private var itemPosition: Int = 0
        private val container = binding.root
        fun bind(card : Platform){



        }


    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomerAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemCardEksplorBinding = ItemPelangganBinding.inflate(layoutInflater,parent,false)
        return ViewHolder(itemCardEksplorBinding)
    }

    override fun onBindViewHolder(holder: CustomerAdapter.ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}