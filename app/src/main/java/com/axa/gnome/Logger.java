package com.axa.gnome;

import android.util.Log;


public class Logger {

    public static int d(String tag, String msg) {
        return Log.d(tag, msg);
    }

    public static int d(String tag, String msg, Throwable tr) {
        return Log.d(tag, msg, tr);
    }

    public static int e(String tag, String msg, Throwable tr) {
        return Log.e(tag, msg, tr);
    }

}
