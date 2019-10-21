package com.sjh.sjhone;

import android.app.Application;

import com.sjh.baselibrary.util.ToastUtils;

/**
 * date: 2019/10/16
 * author:SJH
 * description: My application.
 */
public class App extends Application {
    public static final boolean DEBUG = true;
    public static App MyApp;
    @Override
    public void onCreate() {
        super.onCreate();
        MyApp = this;
    }

    private static App getInstance(){
        return MyApp;
    }

    public static void showToast(String text){
        new ToastUtils(MyApp).showToast(text);
    }
    public static void showImageToast(String text,int resID){
        new ToastUtils(MyApp).showToast(text,resID);
    }
}
