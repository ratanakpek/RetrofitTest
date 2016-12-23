package com.example.advancecourse.homework;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;

import android.os.Bundle;

/**
 * Created by advancecourse on 11/12/16.
 */

public class MyDialog extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new AlertDialog.Builder(getActivity()).setTitle("Error")
                .setMessage("Wrong Email or Password!")
                .setIcon(R.drawable.common_google_signin_btn_icon_dark)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dismiss();
                    }
        }).create();

    }
}
