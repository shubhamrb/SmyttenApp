package com.shubhamahirwar.smyttenapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.shubhamahirwar.smyttenapp.databinding.ActivityFBinding
import com.shubhamahirwar.smyttenapp.viewModels.FViewModel

class ActivityF : AppCompatActivity() {
    private lateinit var binding: ActivityFBinding
    private lateinit var viewModel: FViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[FViewModel::class.java]

        if (intent.hasExtra("name")) {
            binding.toolbar.title = intent.getStringExtra("name")
        }
    }
}