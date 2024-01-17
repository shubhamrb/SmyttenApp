package com.shubhamahirwar.smyttenapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.shubhamahirwar.smyttenapp.databinding.ActivityEBinding
import com.shubhamahirwar.smyttenapp.viewModels.EViewModel

class ActivityE : AppCompatActivity() {
    private lateinit var binding: ActivityEBinding
    private lateinit var viewModel: EViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[EViewModel::class.java]

        if (intent.hasExtra("name")) {
            binding.toolbar.title = intent.getStringExtra("name")
        }
    }
}