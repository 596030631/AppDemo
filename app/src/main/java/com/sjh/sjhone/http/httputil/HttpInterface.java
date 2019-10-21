package com.sjh.sjhone.http.httputil;

import com.sjh.sjhone.http.bean.BaseBean;
import com.sjh.sjhone.http.bean.BaseObjectBean;
import com.sjh.sjhone.http.bean.TouTiaoBean;
import com.sjh.sjhone.http.bean.VideoTopBean;

import java.util.Map;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * date: 2019/10/19
 * author:SJH
 * description:
 */
public interface HttpInterface {
    @GET("toutiao/index")
    Observable<BaseBean<BaseObjectBean<TouTiaoBean>>> getNews(@QueryMap Map<String,String> params);

    @GET("satinApi")
    Observable<VideoTopBean> getVideos(@QueryMap Map<String,String> params);
}
