package com.madtutorial.alertdialogandroid

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class SimpleDialogFragment : DialogFragment(){


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(requireContext()).apply {
            this.setTitle("Dialog Fragment")
            setMessage("This is Dialog Fragment, Do you want to close the dialog?")
            setPositiveButton("Yes"
            ) { dialog, _ -> dialog?.dismiss() }

            setNegativeButton("No"
            ) { dialog, _ -> dialog?.dismiss() }
        }.create()
    }

}