package com.sjh.sjhone.base;

/**
 * date: 2019/10/16
 * author:SJH
 * description:
 */
public class BaseModelImpl implements BaseModel {

    @Override
    public void onDestory() {
        // OkHttpUtils.getInstance().cancelTag(this);//取消请求
    }
}
