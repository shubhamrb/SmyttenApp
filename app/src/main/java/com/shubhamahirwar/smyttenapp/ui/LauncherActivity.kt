package com.shubhamahirwar.smyttenapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.shubhamahirwar.smyttenapp.R
import com.shubhamahirwar.smyttenapp.SmyttenApplication
import com.shubhamahirwar.smyttenapp.viewModels.LauncherViewModel

class LauncherActivity : AppCompatActivity() {
    private lateinit var viewModel: LauncherViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)

        viewModel = ViewModelProvider(this)[LauncherViewModel::class.java]
        viewModel.startSplashCountdown(this)

        (application as SmyttenApplication).startDialogTimer()
    }

}