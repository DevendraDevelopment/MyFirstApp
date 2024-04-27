package com.example.myfirstapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.myfirstapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val TAG: String = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //Todo Fetching the id of the xml files component
//        val editTextTextEmail = findViewById<EditText>(R.id.editTextTextEmail) //replacement
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

        Log.d(TAG, "onCreate: Activity created")
        /**
         * Create a addition program which takes input from a field and b field and result should be print on button click, just after the button
         */
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: Activity started")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: Activity resumed")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: Activity paused")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: Activity stopped")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: Activity destroyed")
    }

    public override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG, "onSaveInstanceState: Saving instance state")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d(TAG, "onRestoreInstanceState: Restoring instance state")
    }
}