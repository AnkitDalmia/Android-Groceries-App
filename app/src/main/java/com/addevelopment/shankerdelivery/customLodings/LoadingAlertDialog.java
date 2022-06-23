package com.addevelopment.shankerdelivery.customLodings;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;

import com.addevelopment.shankerdelivery.R;

public class LoadingAlertDialog {
    private final Activity activity;
    private AlertDialog dialog;

    public LoadingAlertDialog(Activity activity) {
        this.activity = activity;
    }

    public void startLoadingDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        LayoutInflater inflater = activity.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.custom_dialog,null));
        dialog = builder.create();
        dialog.setCancelable(false);
        dialog.show();
    }
    public void dismissDialog(){
        dialog.dismiss();
    }

}
