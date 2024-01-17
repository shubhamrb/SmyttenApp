package com.shubhamahirwar.smyttenapp.viewModels

import android.app.Activity
import android.content.Intent
import android.os.Handler
import android.os.Looper
import androidx.lifecycle.ViewModel
import com.shubhamahirwar.smyttenapp.ui.HomeActivity

class LauncherViewModel : ViewModel() {

    fun startSplashCountdown(activity: Activity) {
        Handler(Looper.getMainLooper()).postDelayed({
            activity.startActivity(Intent(activity, HomeActivity::class.java))
            activity.finish()
        }, 1000)
    }
}