package com.shubhamahirwar.smyttenapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.shubhamahirwar.smyttenapp.databinding.ActivityCBinding
import com.shubhamahirwar.smyttenapp.viewModels.CViewModel

class ActivityC : AppCompatActivity() {
    private lateinit var binding: ActivityCBinding
    private lateinit var viewModel: CViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[CViewModel::class.java]

        if (intent.hasExtra("name")) {
            binding.toolbar.title = intent.getStringExtra("name")
        }
    }
}