package com.steven.testdi.helper;

/**
 * Created by steventsui on 24/2/2017.
 */

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;


public class DialogHelper {

    Context mContext;

    public DialogHelper(Context mContext) {
        this.mContext = mContext;
    }

    public void showSingleButtonDialog(final String message, final String buttonName) {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setCancelable(false);
        builder.setMessage(message);
        builder.setPositiveButton(buttonName, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();
    }


}
