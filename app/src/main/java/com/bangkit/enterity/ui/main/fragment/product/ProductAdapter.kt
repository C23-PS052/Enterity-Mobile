package com.bangkit.enterity.ui.main.fragment.product

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.enterity.databinding.ItemProductBinding
import com.bangkit.enterity.model.DataItemProduct
import com.bumptech.glide.Glide

class ProductAdapter  (
    private val context: Context
)  : ListAdapter<DataItemProduct, ProductAdapter.ViewHolder>(
    DIFF_CALLBACK) {

    private var selectedItemPosition: Int = 0



    inner  class ViewHolder(private var binding : ItemProductBinding) : RecyclerView.ViewHolder(binding.root){
        private var itemPosition: Int = 0
        private val container = binding.root
        fun bind(item : DataItemProduct){

            binding.tvProductName.text = item.nama_produk
            binding.tvPlatform.text =  StringBuilder("Rp. ").append(item?.harga_produk.toString())
            Glide
                .with(context)
                .load(item.url_produk)
                .into(binding.imgProduct)

            binding.tvStok.text = "Stok ${item?.stok.toString()}"


        }


    }

    companion object {
        val DIFF_CALLBACK: DiffUtil.ItemCallback<DataItemProduct> =
            object : DiffUtil.ItemCallback<DataItemProduct>() {
                override fun areItemsTheSame(oldUser: DataItemProduct, newUser: DataItemProduct): Boolean {
                    return oldUser.id == newUser.id
                }

                @SuppressLint("DiffUtilEquals")
                override fun areContentsTheSame(oldUser: DataItemProduct, newUser: DataItemProduct): Boolean {
                    return oldUser == newUser
                }
            }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemCardEksplorBinding = ItemProductBinding.inflate(layoutInflater,parent,false)
        return ViewHolder(itemCardEksplorBinding)
    }

    override fun onBindViewHolder(holder: ProductAdapter.ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


}