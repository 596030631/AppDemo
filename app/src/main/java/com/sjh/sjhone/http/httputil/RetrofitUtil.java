package com.sjh.sjhone.http.httputil;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.sjh.baselibrary.util.Logger;
import com.sjh.sjhone.http.bean.BaseBean;
import com.sjh.sjhone.http.bean.BaseObjectBean;
import com.sjh.sjhone.http.bean.TouTiaoBean;
import com.sjh.sjhone.http.bean.VideoTopBean;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * date: 2019/10/19
 * author:SJH
 * description:
 */
public class RetrofitUtil {
    /*set http interceptor and level equals body*/
    private static HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
        @Override
        public void log(String message) {
            Logger.d(message);
        }
    }).setLevel(HttpLoggingInterceptor.Level.BODY);//BASIC、HEADER、BODY、NONE : The data is BODY you can logger more info.

    private static OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder().addInterceptor(loggingInterceptor);

    private static Retrofit retrofit;
    private static HttpInterface getRetrofit(String BaseUrl){
        retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .client(okHttpBuilder.build())
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
