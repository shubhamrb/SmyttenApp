package com.shubhamahirwar.smyttenapp

import android.app.Activity
import android.app.Application
import android.content.DialogInterface
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AlertDialog
import java.lang.ref.WeakReference

class SmyttenApplication : Application() {
    private lateinit var currentActivity: WeakReference<Activity>

    override fun onCreate() {
        super.onCreate()

        registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks {
            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                currentActivity = WeakReference(activity)
            }

            override fun onActivityStarted(activity: Activity) {}

            override fun onActivityResumed(activity: Activity) {
                currentActivity = WeakReference(activity)
            }

            override fun onActivityPaused(activity: Activity) {}

            override fun onActivityStopped(activity: Activity) {}

            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {}

            override fun onActivityDestroyed(activity: Activity) {
                if (currentActivity.get() == activity) {
                    currentActivity.clear()
                }
            }
        })

    }

    fun startDialogTimer() {
        Handler(Looper.getMainLooper()).postDelayed({
            showSmyttenDialog()
        }, 5000)
    }

    private fun getCurrentActivity(): Activity? {
        return currentActivity.get()
    }

    private fun showSmyttenDialog() {
        val currentActivity = getCurrentActivity()

        if (currentActivity != null) {
            val alertDialog = AlertDialog.Builder(currentActivity)
            alertDialog.setCancelable(false)
            alertDialog.setTitle(R.string.app_name)
            alertDialog.setMessage("Hello!")
            alertDialog.setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which ->
                dialog.dismiss()
            })
            alertDialog.show()
            /*alertDialog.window?.setLayout(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT
            )*/

        }
    }
}