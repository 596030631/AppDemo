package com.sjh.sjhone.model;

import com.sjh.sjhone.base.BaseModel;
import com.sjh.sjhone.http.bean.BaseBean;
import com.sjh.sjhone.http.bean.BaseObjectBean;
import com.sjh.sjhone.http.bean.TouTiaoBean;

import io.reactivex.Observer;

/**
 * date: 2019/10/20
 * author:SJH
 * description:
 */
public interface HomeModel extends BaseModel {
    void getNews(Observer<BaseBean<BaseObjectBean<TouTiaoBean>>> observer);
}
