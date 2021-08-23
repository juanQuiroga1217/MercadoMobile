package com.mercadolibreprueba.mercadomobile.controller;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.mercadolibreprueba.mercadomobile.R;
import com.mercadolibreprueba.mercadomobile.model.ConstantsApp;

import java.util.Objects;


/**
 * **************************************************************************
 * NAME: Messages.java
 * DESCRIPTION:  Show Messages to User and Developer.
 * UPDATES:
 * VERSION      DATE       AUTOR      REQUIREMENT              UPDATE DESCRIPTION
 * -------  ------------  ----------  ---------------  -------------------------------------------------
 * 1.0       21/08/2021   jquiroga      creation                    creation
 * ***************************************************************************
 */

public class MessagesApp {

    private MessagesApp() {
        throw new IllegalAccessError("Clase Mensajes App");
    }

    public static void showToast (String message, Context context) {
        try {
            Toast.makeText(context, message, Toast.LENGTH_LONG).show();
        }catch (Exception e){
            LogMessageException(context.getClass(), e);
        }
    }


    /* Loading Messages */

    public static @NonNull
    Dialog getDialogLoading(String message, Context context) {
        final Dialog dialog = new Dialog(context);

        try {
            dialog.setContentView(R.layout.custom_message_loading);
            dialog.setCancelable(false);
            if (dialog.getWindow() != null)
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            ((TextView)dialog.findViewById(R.id.txtLoading)).setText(message);
        } catch (Exception e){
            LogMessageException(context.getClass(), e);
        }

        return dialog;
    }

    /* Normal Messages */


    public static void showAlertMessage(String message, String btnText, Context context) {
        try {
            int imgAlert = R.drawable.img_info_message;
            getDialog(message, btnText, imgAlert, context).show();
        }catch (Exception e){
            LogMessageException(context.getClass(), e);
        }
    }


    private static @NonNull Dialog getDialog(String message, String btnText, int imgDialog, Context context) {
        final Dialog dialog = new Dialog(context);
        try {
            dialog.setContentView(R.layout.custom_message);
            getGenericMessage(message, btnText, imgDialog, dialog);
        }catch (Exception e){
            LogMessageException(context.getClass(), e);
        }
        return dialog;
    }


    private static void getGenericMessage(String message, String btnText, int imgDialog, @NonNull final Dialog dialog) {

        ((TextView)dialog.findViewById(R.id.txtMessage)).setText(message);
        ((Button)dialog.findViewById(R.id.btnOkMessage)).setText(btnText);
        ((ImageView)dialog.findViewById(R.id.ivMessageIcon)).setImageResource(imgDialog);
        dialog.findViewById(R.id.btnOkMessage).setOnClickListener(v -> dialog.dismiss());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        if (dialog.getWindow() != null)
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }



    /*Exceptions and logs  */


    public static void LogMessageException(Class<?> method, Exception exception){
        try {
            if (method != null && method.getEnclosingMethod() != null)
                Log.d(ConstantsApp.LOG_MERCADO_MOBILE, method.getEnclosingMethod().getName() + ConstantsApp.SPACE + exception.getMessage());
            else
                Log.d(ConstantsApp.LOG_MERCADO_MOBILE, Objects.requireNonNull(exception.getMessage()));
        } catch (Exception e){
            Log.d(ConstantsApp.LOG_MERCADO_MOBILE, e.getMessage(), e);
        }
    }



    public static void LogApiException(Class<?> method, String exception){
        try {
            if (method != null && method.getEnclosingMethod() != null)
                Log.d(ConstantsApp.LOG_MERCADO_MOBILE, method.getEnclosingMethod().getName() + ConstantsApp.SPACE + exception);
            else
                Log.d(ConstantsApp.LOG_MERCADO_MOBILE, Objects.requireNonNull(exception));
        } catch (Exception e){
            Log.d(ConstantsApp.LOG_MERCADO_MOBILE, e.getMessage(), e);
        }
    }



    public static void logMessage(String message) {
        try {
            Log.d(ConstantsApp.LOG_MERCADO_MOBILE, message);
        } catch (Exception e){
            Log.d(ConstantsApp.LOG_MERCADO_MOBILE, e.getMessage(), e);
        }
    }

}
