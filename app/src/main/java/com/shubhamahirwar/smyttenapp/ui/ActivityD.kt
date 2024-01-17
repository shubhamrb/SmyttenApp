package com.shubhamahirwar.smyttenapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.shubhamahirwar.smyttenapp.databinding.ActivityDBinding
import com.shubhamahirwar.smyttenapp.viewModels.DViewModel

class ActivityD : AppCompatActivity() {
    private lateinit var binding: ActivityDBinding
    private lateinit var viewModel: DViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[DViewModel::class.java]

        if (intent.hasExtra("name")) {
            binding.toolbar.title = intent.getStringExtra("name")
        }
    }
}