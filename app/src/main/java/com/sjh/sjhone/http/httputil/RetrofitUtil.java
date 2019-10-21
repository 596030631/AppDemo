package com.sjh.sjhone.http.httputil;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.sjh.sjhone.http.bean.BaseBean;
import com.sjh.sjhone.http.bean.BaseObjectBean;
import com.sjh.sjhone.http.bean.TouTiaoBean;
import com.sjh.sjhone.http.bean.VideoTopBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * date: 2019/10/19
 * author:SJH
 * description:
 */
public class RetrofitUtil {
    private static Retrofit retrofit;
    private static HttpInterface getRetrofit(String BaseUrl){
        retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(HttpInterface.class);
    }

    public static Observable<BaseBean<BaseObjectBean<TouTiaoBean>>> getNews(Map<String,String> params){
        return getRetrofit(BaseInfo.BASE_URL_TT).getNews(params);
    }

    public static Observable<VideoTopBean> getVideos(Map<String,String> params){
        return getRetrofit(BaseInfo.BASE_URL_VIDEO).getVideos(params);
    }
}
