package com.saikat1102.cfood;

import android.app.AlertDialog;
import android.content.DialogInterface;

public class ReusableCodeForAll {
    public static void ShowAlert(ChefRegistration context, String title, String message){
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
