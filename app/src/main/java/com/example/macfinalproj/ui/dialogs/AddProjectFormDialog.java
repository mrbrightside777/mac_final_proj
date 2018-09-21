package com.example.macfinalproj.ui.dialogs;

import android.app.AlertDialog;
import android.content.Context;

public class AddProjectFormDialog extends AlertDialog {
    protected AddProjectFormDialog(Context context) {
        super(context);
    }

    protected AddProjectFormDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    protected AddProjectFormDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    
}
