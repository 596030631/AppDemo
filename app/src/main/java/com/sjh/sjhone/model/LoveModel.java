package com.sjh.sjhone.model;

import com.sjh.sjhone.base.BaseModel;
import com.sjh.sjhone.http.bean.VideoTopBean;

import io.reactivex.Observer;

/**
 * date: 2019/10/20
 * author:SJH
 * description:
 */
public interface LoveModel extends BaseModel {
    void getVideos(String type, String page, Observer<VideoTopBean> observable);

}
