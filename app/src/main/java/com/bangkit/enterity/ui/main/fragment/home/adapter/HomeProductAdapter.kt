package com.bangkit.enterity.ui.main.fragment.home.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.enterity.databinding.ItemPlatformBinding
import com.bangkit.enterity.databinding.ItemProductBinding
import com.bangkit.enterity.model.DataItem
import com.bangkit.enterity.model.DataItemProduct
import com.bangkit.enterity.model.Platform
import com.bangkit.enterity.ui.main.MainViewModel
import com.bumptech.glide.Glide
import javax.inject.Inject

class HomeProductAdapter (
    private val context: Context
)  : ListAdapter<DataItem, HomeProductAdapter.ViewHolder>(
    DIFF_CALLBACK) {






    inner  class ViewHolder(private var binding : ItemProductBinding) : RecyclerView.ViewHolder(binding.root){
        private var itemPosition: Int = 0
        private val container = binding.root
        fun bind(item : DataItem){
            binding.tvProductName.text = item.produk?.nama_produk
            binding.tvPlatform.text = item.platform?.nama_channel
            Glide
                .with(context)
                .load(item.produk?.url_produk)
                .into(binding.imgProduct)

            binding.tvStok.text = "Stok ${item.produk?.stok.toString()}"


        }


    }

    companion object {
        val DIFF_CALLBACK: DiffUtil.ItemCallback<DataItem> =
            object : DiffUtil.ItemCallback<DataItem>() {
                override fun areItemsTheSame(oldUser: DataItem, newUser: DataItem): Boolean {
                    return oldUser.produk?.id == newUser.produk?.id
                }

                @SuppressLint("DiffUtilEquals")
                override fun areContentsTheSame(oldUser: DataItem, newUser: DataItem): Boolean {
                    return oldUser == newUser
                }
            }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeProductAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemCardEksplorBinding = ItemProductBinding.inflate(layoutInflater,parent,false)
        return ViewHolder(itemCardEksplorBinding)
    }

    override fun onBindViewHolder(holder: HomeProductAdapter.ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


}