package com.madtutorial.alertdialogandroid

import android.app.Dialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import java.time.LocalDate

class MainActivity : AppCompatActivity() {

    private lateinit var showDialogButton: Button
    private lateinit var showDialogFragmentButton: Button
    private lateinit var showCustomDialogButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showDialogButton = findViewById(R.id.showDialogButton)
        showDialogButton.setOnClickListener {
            showDialog()
        }

        showDialogFragmentButton = findViewById(R.id.showDialogFragmentButton)
        showDialogFragmentButton.setOnClickListener {
            showDialogFragment()
        }

        showCustomDialogButton = findViewById(R.id.showCustomDialogButton)
        showCustomDialogButton.setOnClickListener {
            showCustomDialog()
        }

    }

    private fun showCustomDialog(){

        val alertDialog = AlertDialog.Builder(this).apply {
            setView(R.layout.custom_dialog_layout)
        }.create()

        alertDialog.show()
        alertDialog.findViewById<Button>(R.id.closeThisDialog)?.setOnClickListener {
            Log.d("Dialog","IS TRIGGERED")
            alertDialog.dismiss()
        }
        if (alertDialog.isShowing){
            Log.d("DialogStatus","alertDialog.isShowing? --- ${alertDialog.isShowing}")
        }

    }

    private fun showDialogFragment() {
        val dialogFragment = SimpleDialogFragment()
        dialogFragment.show(supportFragmentManager,"DialogFragment")
    }

    private fun showDialog(){
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.apply {
            setTitle("Simple Dialog")
            setMessage("This is simple default dialog")
            setCancelable(false)
            setPositiveButton("OK",object :DialogInterface.OnClickListener{
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    dialog?.dismiss()
                }

            })

            setNegativeButton("Cancel") { dialog, which ->
                dialog?.cancel()
            }

//            create()
        }

        alertDialog.show()
    }

}