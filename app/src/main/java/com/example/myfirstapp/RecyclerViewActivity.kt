package com.example.myfirstapp

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.myfirstapp.databinding.ActivityRecyclerViewBinding

class RecyclerViewActivity : AppCompatActivity() {
    lateinit var binding: ActivityRecyclerViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProvider(this).get(FeedsViewModel::class.java)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_recycler_view)
//        setContentView(R.layout.activity_recycler_view)


        viewModel.feeds.observe(this) {
            binding.recyclerView.adapter = FeedListAdapter(this, it)
        }

        //1. recyclerView Tag //activity/Fragment
        //2. item (design a single item)
        //3. Adapter
        //4. Provide the property of recyclerView of layoutManager
        //5. data => List

    }
}