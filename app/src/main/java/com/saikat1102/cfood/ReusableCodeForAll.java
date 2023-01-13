package com.saikat1102.cfood;

import android.app.AlertDialog;
import android.content.DialogInterface;

import com.google.firebase.database.core.Context;

public class ReusableCodeForAll {
    Context context;
    public static void ShowAlert(android.content.Context context, String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(false);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).setTitle(title).setMessage(message).show();
    }
}
