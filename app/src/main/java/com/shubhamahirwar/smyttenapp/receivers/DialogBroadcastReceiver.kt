package com.shubhamahirwar.smyttenapp.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import com.shubhamahirwar.smyttenapp.R

class DialogBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == "SHOW_DIALOG_ACTION") {
            showSmyttenDialog(context)
        }
    }

    private fun showSmyttenDialog(context: Context?) {
        val dialogView = LayoutInflater.from(context).inflate(R.layout.welcome_dialog, null)
        val dialogNeutralButton = dialogView.findViewById<Button>(R.id.dialogNeutralButton)

        val alertDialogBuilder = AlertDialog.Builder(context!!)
            .setView(dialogView)
            .setCancelable(false)

        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()

        dialogNeutralButton.setOnClickListener {
            alertDialog.dismiss()
        }
    }
}