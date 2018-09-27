package com.example.macfinalproj.ui.dialogs

import android.app.AlertDialog
import android.content.Context

class AddProjectFormDialog : AlertDialog {
    protected constructor(context: Context) : super(context) {}

    protected constructor(context: Context, cancelable: Boolean, cancelListener: DialogInterface.OnCancelListener) : super(context, cancelable, cancelListener) {}

    protected constructor(context: Context, themeResId: Int) : super(context, themeResId) {}


}
