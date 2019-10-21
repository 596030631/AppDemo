package com.sjh.baselibrary.util;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

/**
 * date: 2019/10/16
 * author:SJH
 * description:
 */
public class ToastUtils {
    private Context mContext;
    private Toast mToast;

    public ToastUtils(Context ctx){
        mContext = ctx;
    }

    public void showToast(String content){
        showTextMethods(content);
    }

    public void showToast(String text,int resID){
        showResMethods(text,resID);
    }

    private void showTextMethods(String text){
        if (mToast == null) {
            mToast = Toast.makeText(mContext,text,Toast.LENGTH_SHORT);
        }else {
            mToast.setText(text);
        }
        mToast.setGravity(Gravity.CENTER,0,0);
        mToast.show();
    }
    private void showResMethods(String text ,int resID){
        mToast = Toast.makeText(mContext,text,Toast.LENGTH_SHORT);
        View view = mToast.getView();
        if(view != null) {
            view.setBackgroundResource(resID);
        }
        mToast.setGravity(Gravity.CENTER,0,0);
        mToast.show();
    }
}
