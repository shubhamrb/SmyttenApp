package com.shubhamahirwar.smyttenapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.shubhamahirwar.smyttenapp.databinding.ActivityABinding
import com.shubhamahirwar.smyttenapp.viewModels.AViewModel

class ActivityA : AppCompatActivity() {
    private lateinit var binding: ActivityABinding
    private lateinit var viewModel: AViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityABinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[AViewModel::class.java]

        if (intent.hasExtra("name")) {
            binding.toolbar.title = intent.getStringExtra("name")
        }
    }
}