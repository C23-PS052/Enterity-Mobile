package com.bangkit.enterity.ui.main.fragment.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.enterity.databinding.ItemPlatformBinding
import com.bangkit.enterity.databinding.ItemProductBinding
import com.bangkit.enterity.model.Platform
import com.bumptech.glide.Glide

class HomePlatformAdapter  (
    private val context: Context,
    val list : List<Platform>
)  : RecyclerView.Adapter<HomePlatformAdapter.ViewHolder>() {

    private var selectedItemPosition: Int = 0


    inner  class ViewHolder(private var binding : ItemPlatformBinding) : RecyclerView.ViewHolder(binding.root){
        private var itemPosition: Int = 0
        private val container = binding.root
        fun bind(item : Platform){

            Glide
                .with(context)
                .load(item.image)
                .into(binding.imgPlatform)



        }


    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomePlatformAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemCardEksplorBinding = ItemPlatformBinding.inflate(layoutInflater,parent,false)
        return ViewHolder(itemCardEksplorBinding)
    }

    override fun onBindViewHolder(holder: HomePlatformAdapter.ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}