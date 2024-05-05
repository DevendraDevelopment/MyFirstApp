package com.example.myfirstapp

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide

class ImageLoadingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_loading)

        val imageView = findViewById<ImageView>(R.id.imageView)

        //USE of glide

        Glide
            .with(this)
            .load("https://api.time.com/wp-content/uploads/2020/11/best-inventions-of-2020-Perso-3.jpg")
            .into(imageView)
    }
}