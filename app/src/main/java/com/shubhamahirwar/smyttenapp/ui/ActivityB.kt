package com.shubhamahirwar.smyttenapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.shubhamahirwar.smyttenapp.databinding.ActivityBBinding
import com.shubhamahirwar.smyttenapp.viewModels.AViewModel
import com.shubhamahirwar.smyttenapp.viewModels.BViewModel

class ActivityB : AppCompatActivity() {
    private lateinit var binding: ActivityBBinding
    private lateinit var viewModel: BViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[BViewModel::class.java]

        if (intent.hasExtra("name")) {
            binding.toolbar.title = intent.getStringExtra("name")
        }
    }
}