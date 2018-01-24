package com.example.abhay.examapp.Database;

import android.content.Context;
import android.widget.Toast;


/**
 * This section of the code, i.e the Message method is used to display a toast message
 * on the phone screen whenever a button is clicked in the SQL lite feature of the application.
 * To know more check the app in the phone.
 **/


public class Message

{
    public static void message(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
