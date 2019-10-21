package com.sjh.sjhone.http.httputil;

import com.sjh.sjhone.http.bean.BaseBean;
import com.sjh.sjhone.http.bean.BaseObjectBean;
import com.sjh.sjhone.http.bean.TouTiaoBean;
import com.sjh.sjhone.http.bean.VideoTopBean;
import java.util.Map;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * date: 2019/10/19
 * author:SJH
 * description:
 */
public class NetUtil {
    public static BaseBean<BaseObjectBean<TouTiaoBean>> getNews(Map<String,String> params1, Observer<BaseBean<BaseObjectBean<TouTiaoBean>>> observer){
        RetrofitUtil.getNews(params1).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
        return null;
    }

    public static BaseBean<VideoTopBean> getVideos(Map<String,String> params2, Observer<VideoTopBean> observer){
        RetrofitUtil.getVideos(params2).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
        return null;
    }
}
