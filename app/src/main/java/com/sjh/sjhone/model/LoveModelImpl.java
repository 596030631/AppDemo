package com.sjh.sjhone.model;

import com.sjh.sjhone.base.BaseModelImpl;
import com.sjh.sjhone.http.bean.VideoTopBean;
import com.sjh.sjhone.http.httputil.NetUtil;

import java.util.HashMap;

import io.reactivex.Observer;

/**
 * date: 2019/10/20
 * author:SJH
 * description:
 */
public class LoveModelImpl extends BaseModelImpl implements LoveModel {
    public void getVideos(String type, String page,Observer<VideoTopBean> observer) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("type", type);
        hashMap.put("page", page);
        NetUtil.getVideos(hashMap, observer);
    }

}
