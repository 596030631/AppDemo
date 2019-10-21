package com.sjh.sjhone.model;

import com.sjh.sjhone.base.BaseModelImpl;
import com.sjh.sjhone.http.bean.BaseBean;
import com.sjh.sjhone.http.bean.BaseObjectBean;
import com.sjh.sjhone.http.bean.TouTiaoBean;
import com.sjh.sjhone.http.httputil.BaseInfo;
import com.sjh.sjhone.http.httputil.NetUtil;

import java.util.HashMap;

import io.reactivex.Observer;

/**
 * date: 2019/10/19
 * author:SJH
 * description:
 */
public class HomeModelImpl extends BaseModelImpl implements HomeModel{
    public void getNews(Observer<BaseBean<BaseObjectBean<TouTiaoBean>>> observer){
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("type","top");
        hashMap.put("key", BaseInfo.APP_APPLY);
        NetUtil.getNews(hashMap,observer);
    }
}
