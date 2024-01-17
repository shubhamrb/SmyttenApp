package com.shubhamahirwar.smyttenapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.shubhamahirwar.smyttenapp.adapter.HomeVerticalAdapter
import com.shubhamahirwar.smyttenapp.databinding.ActivityHomeBinding
import com.shubhamahirwar.smyttenapp.models.Content
import com.shubhamahirwar.smyttenapp.viewModels.HomeViewModel

class HomeActivity : AppCompatActivity() {
    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        viewModel.contentModel.observe(this) {
            loadData(it.content)
        }
        viewModel.loadJsonFile(this)
    }


    private fun loadData(content: List<Content>) {
        val verticalAdapter = HomeVerticalAdapter(this)
        binding.verticalRecyclerView.layoutManager =
            LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.verticalRecyclerView.adapter = verticalAdapter
        verticalAdapter.setList(content)
    }
}