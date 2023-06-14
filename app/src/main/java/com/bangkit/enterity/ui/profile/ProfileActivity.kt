package com.bangkit.enterity.ui.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.preference.PreferenceManager
import com.bangkit.enterity.R
import com.bangkit.enterity.databinding.ActivityProfileBinding
import com.bangkit.enterity.ui.start.StartActivity

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding : ActivityProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val editor = pref.edit()
        binding.btnLogout.setOnClickListener {
            startActivity(
                Intent(this, StartActivity::class.java)
                .putExtra("logout",true)
                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK))

            editor.putBoolean(getString(R.string.isLogin), false)
            editor.apply()
        }





        setContentView(binding.root)
    }
}