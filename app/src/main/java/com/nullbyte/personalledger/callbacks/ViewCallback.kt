package com.nullbyte.personalledger.callbacks

import android.app.AlertDialog
import android.view.View

interface ViewCallback {
    fun onSuccess(view: View, dialog: AlertDialog)
}