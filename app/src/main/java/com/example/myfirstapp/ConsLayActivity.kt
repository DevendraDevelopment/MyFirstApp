package com.example.myfirstapp

import android.content.Intent
import android.os.Bundle
import android.widget.CompoundButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.myfirstapp.databinding.ActivityConsLayBinding

class ConsLayActivity : AppCompatActivity() {
    private lateinit var binding : ActivityConsLayBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_cons_lay)


        binding.button.setOnClickListener {
            if (binding.checkBox.isChecked){
                Toast.makeText(this, "Saved", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Please check your checkbox", Toast.LENGTH_LONG).show()
            }
        }

        binding.checkBox.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                Toast.makeText(this, "Checked", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Unchecked", Toast.LENGTH_LONG).show()

            }
        }

        binding.textViewForgotPassword.setOnClickListener {
            var intent =  Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.textViewSignUp.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}