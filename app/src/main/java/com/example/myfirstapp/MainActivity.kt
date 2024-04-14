package com.example.myfirstapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.databinding.DataBindingUtil
import com.example.myfirstapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //Todo Fetching the id of the xml files component
//        val editTextTextEmail = findViewById<EditText>(R.id.editTextTextEmail)
//        val editTextTextPassword = findViewById<EditText>(R.id.editTextTextPassword)

        val button = binding.button//findViewById<Button>(R.id.button)

        //TODO define the action
        button.setOnClickListener {

            //TODO Tradional way finding id
//            val textViewEmailValue = findViewById<TextView>(R.id.textViewEmailValue)
//            val textViewPasswordValue = findViewById<TextView>(R.id.textViewPasswordValue)

            if (binding.editTextTextEmail.text.isEmpty()) {
                binding.editTextTextEmail.error = "Email id can't be empty"
            } else if (binding.editTextTextPassword.text.isEmpty()) {
                binding.editTextTextPassword.error = "Password can't be empty"
            } else {
                val intent: Intent
                intent = Intent(this, InfoActivity::class.java)
                intent.putExtra("email", binding.editTextTextEmail.text.toString())
                intent.putExtra("password", binding.editTextTextPassword.text.toString())
                startActivity(intent)
//                try {
//                    //TODO Getting the data for further use
//                    binding.textViewEmailValue.text = binding.editTextTextEmail.text.toString()
//                    binding.textViewPasswordValue.text = binding.editTextTextPassword.text.toString()
//
//
//                    Toast.makeText(
//                        application,
//                        "Info :: ${binding.textViewEmailValue.text} :: ${binding.textViewPasswordValue.text}",
//                        Toast.LENGTH_LONG
//                    ).show()
//                } catch (e: Exception) {
//                    e.printStackTrace()
//                }
            }
        }


        /**
         * Create a addition program which takes input from a field and b field and result should be print on button click, just after the button
         */
    }
}