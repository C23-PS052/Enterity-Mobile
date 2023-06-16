package com.bangkit.enterity.ui.main.fragment.customer

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.enterity.databinding.ItemPelangganBinding
import com.bangkit.enterity.model.DataItemPelanggan
import com.bumptech.glide.Glide

class CustomerAdapter (
    private val context: Context,

)  : ListAdapter<DataItemPelanggan, CustomerAdapter.ViewHolder>(
    CustomerAdapter.DIFF_CALLBACK
) {

    private var selectedItemPosition: Int = 0


    inner  class ViewHolder(private var binding : ItemPelangganBinding) : RecyclerView.ViewHolder(binding.root){
        private var itemPosition: Int = 0
        private val container = binding.root
        fun bind(item : DataItemPelanggan){

            binding.tvPlatform.text = item.email
            binding.tvProductName.text = item.nama_pelanggan
            binding.transaction.text = item.jenis_kelamin
            Glide
                .with(context)
                .load(item.url_pelanggan)
                .into(binding.imgPelanggan)

        }

    }


    companion object {
        val DIFF_CALLBACK: DiffUtil.ItemCallback<DataItemPelanggan> =
            object : DiffUtil.ItemCallback<DataItemPelanggan>() {
                override fun areItemsTheSame(oldUser: DataItemPelanggan, newUser: DataItemPelanggan): Boolean {
                    return oldUser.id == newUser.id
                }

                @SuppressLint("DiffUtilEquals")
                override fun areContentsTheSame(oldUser: DataItemPelanggan, newUser: DataItemPelanggan): Boolean {
                    return oldUser == newUser
                }
            }
    }





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomerAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemCardEksplorBinding = ItemPelangganBinding.inflate(layoutInflater,parent,false)
        return ViewHolder(itemCardEksplorBinding)
    }

    override fun onBindViewHolder(holder: CustomerAdapter.ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


}