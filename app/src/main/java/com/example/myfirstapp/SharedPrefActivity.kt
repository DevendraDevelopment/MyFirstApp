package com.example.myfirstapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity


class SharedPrefActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_pref)


        val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)

        //Store the data
        val editor = sharedPreferences.edit()
        editor.putString("key", "value")
        editor.putBoolean("isLogged", true)
        editor.putString("keyToRemove", "This is the example of remove data")
        editor.apply()


        val value = sharedPreferences.getString("key", "defaultValue")
        val isLogged = sharedPreferences.getBoolean("isLogged", false)

        Log.d("Shared Preferences values", value.toString())

//        val editor = sharedPreferences.edit()
        editor.remove("keyToRemove")
        editor.apply()


//        val editor = sharedPreferences.edit()
//        editor.clear()
//        editor.apply()
    }
}