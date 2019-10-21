package com.sjh.baselibrary.util;
import android.content.ActivityNotFoundException;
import android.database.sqlite.SQLiteFullException;
import android.util.Log;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
/**
 * date: 2019/10/16
 * author:SJH
 * description:
 */
public class Logger {

    public static boolean Debug = true;

    private static final String TAG = "MyLog";

    public static void printStackTrace(String TAG, Exception e) {
        if (Debug) {
            e.printStackTrace();
        } else {
            logException(TAG, e);
        }
    }

    public static void printStackTrace(String TAG, IOException e) {
        if (Debug) {
            e.printStackTrace();
        } else {
            logException(TAG, e);
        }
    }
    public static void printStackTrace(String TAG, MalformedURLException e) {
        if (Debug) {
            e.printStackTrace();
        } else {
            logException(TAG, e);
        }
    }

    public static void printStackTrace(String TAG, IllegalArgumentException e) {
        if (Debug) {
            e.printStackTrace();
        } else {
            logException(TAG, e);
        }
    }


    public static void printStackTrace(String TAG, ActivityNotFoundException e) {
        if (Debug) {
            e.printStackTrace();
        } else {
            logException(TAG, e);
        }
    }

    public static void printStackTrace(String TAG, IndexOutOfBoundsException e) {
        if (Debug) {
            e.printStackTrace();
        } else {
            logException(TAG, e);
        }
    }
    public static void printStackTrace(String TAG, FileNotFoundException e) {
        if (Debug) {
            e.printStackTrace();
        } else {
            logException(TAG, e);
        }
    }

    public static void printStackTrace(String TAG, android.database.sqlite.SQLiteException e) {
        if (Debug) {
            e.printStackTrace();
        } else {
            logException(TAG, e);
        }
    }

    public static void printStackTrace(String TAG, SQLiteFullException e) {
        if (Debug) {
            e.printStackTrace();
        } else {
            logException(TAG, e);
        }
    }

    public static void printStackTrace(String TAG, Throwable e) {
        if (Debug) {
            e.printStackTrace();
        } else {
            logException(TAG, e);
        }
    }

    private static void logException(String TAG, Throwable ex) {

    }

    public static void d(String tag, String msg) {
        if (Debug) {
            Log.d("" + tag, "" + msg);
        }
    }

    public static void d(String msg) {
        Log.d(TAG, msg);
    }

    public static void d(String tag, String msg, Throwable tr) {
        if (Debug) {
            Log.d(tag, msg, tr);
        }
    }

    public static void e(Throwable tr) {
        if (Debug) {
            Log.e(TAG, "", tr);
        }
    }

    public static void i(String msg) {
        if (Debug) {
            Log.i(TAG, msg);
        }
    }

    public static void i(String tag, String msg) {
        if (Debug) {
            Log.i(tag, msg);
        }
    }

    public static void i(String tag, String msg, Throwable tr) {
        if (Debug) {
            Log.i(tag, msg, tr);
        }

    }

    public static void e(String tag, String msg) {
        if (Debug) {
            Log.e(tag, msg);
        }
    }

    public static void e(String msg) {
        if (Debug) {
            Log.e(TAG, msg);
        }
    }

    public static void e(String tag, String msg, Throwable tr) {
        if (Debug) {
            Log.e(tag, msg, tr);
        }
    }

    public static void e(String msg, Throwable tr) {
        if (Debug) {
            Log.e(TAG, msg, tr);
        }
    }

    public static void showLogCompletion(String TAG, String log) {
        int showCount = 2000;
        if (log.length() > showCount) {
            String show = log.substring(0, showCount);
            d(TAG, show + "");
            if ((log.length() - showCount) > showCount) {//剩下的文本还是大于规定长度
                String partLog = log.substring(showCount, log.length());
                showLogCompletion(TAG, partLog);
            } else {
                String surplusLog = log.substring(showCount, log.length());
                d(TAG, surplusLog + "");
            }
        } else {
            d(TAG, log);
        }
    }
}
