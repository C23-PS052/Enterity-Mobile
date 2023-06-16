package com.bangkit.enterity.ui.main.fragment.home.ViewHolder

import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import com.bangkit.enterity.databinding.HomeTopBinding
import com.bangkit.enterity.ui.main.MainViewModel
import com.bangkit.enterity.ui.main.fragment.home.HomeViewModel
import com.bangkit.enterity.ui.profile.ProfileActivity

class HomeTop(private val binding: HomeTopBinding) : HomeViewHolder (binding.root)  {

    override fun bind(context: Context, viewModel: MainViewModel, parent: Fragment) {

        binding.imgProfile.setOnClickListener {
            context.startActivity(Intent(context,ProfileActivity::class.java))
        }


    }
}