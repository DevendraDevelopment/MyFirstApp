package com.example.myfirstapp

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.myfirstapp.databinding.ActivityInfoBinding

class InfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_info)

        val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)

        binding.textViewEmailValue.text = sharedPreferences.getString("email", "defaultValue")
        binding.textViewPasswordValue.text = sharedPreferences.getString("password", "defaultValue")


        binding.button.setOnClickListener {
            logout(sharedPreferences)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
//        binding.textViewEmailValue.text = intent.getStringExtra("email")
//        binding.textViewPasswordValue.text = intent.getStringExtra("password")

    }

    private fun logout(sharedPreferences: SharedPreferences) {
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()
    }
}