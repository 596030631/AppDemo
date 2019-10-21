package com.sjh.sjhone.presenter.main;
import android.content.Context;
import android.text.TextUtils;

import com.sjh.sjhone.http.bean.BaseBean;
import com.sjh.sjhone.http.bean.BaseObjectBean;
import com.sjh.sjhone.http.bean.TouTiaoBean;
import com.sjh.sjhone.model.HomeModel;
import com.sjh.sjhone.presenter.base.BasePresenterImpl;
import com.sjh.sjhone.view.adapter.HomeMainAdapter;
import com.sjh.sjhone.model.HomeModelImpl;
import com.sjh.sjhone.view.main.HomeView;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
/**
 * date: 2019/10/19
 * author:SJH
 * description:
 */
public class HomePresenterImpl extends BasePresenterImpl<HomeView, HomeModel> {
    private List<TouTiaoBean> mList = new ArrayList<>();
    private HomeMainAdapter mAdapter;
    private List<List<String>> mImage = new ArrayList<>();

    @Override
    public HomeModel initModel() {
        return new HomeModelImpl();
    }

    @Override
    public void initData() {
        if(mList == null){
            mList = new ArrayList<>();
        }
        getNewsData();
    }

    public HomeMainAdapter getAdapter(Context ctx) {
        if (mAdapter == null) {
            mAdapter = new HomeMainAdapter(ctx, mList,mImage);
        }
        return mAdapter;
    }

    public void getNewsData(){
        mModel.getNews(new Observer<BaseBean<BaseObjectBean<TouTiaoBean>>>(){
            @Override
            public void onSubscribe(Disposable d) {  }
            @Override
            public void onNext(BaseBean<BaseObjectBean<TouTiaoBean>> bean) {
                if(bean == null) {
                    return;
                }
                if(bean.getError_code() == 10012){
                   return;
                }

                if(bean.getResult() == null){
                    return;
                }

                mList.addAll(bean.getResult().getData());
                for (int i = 0; i < mList.size(); i++) {
                    List<String> list = new ArrayList<>();
                    String url1 = mList.get(i).getThumbnail_pic_s();
                    String url2 = mList.get(i).getThumbnail_pic_s02();
                    String url3 = mList.get(i).getThumbnail_pic_s03();
                    if(!TextUtils.isEmpty(url1)){
                        list.add(url1);
                    }
                    if(!TextUtils.isEmpty(url2)){
                        list.add(url2);
                    }
                    if(!TextUtils.isEmpty(url3)){
                        list.add(url3);
                    }
                    mImage.add(list);
                }
                mAdapter.notifyDataSetChanged();
            }
            @Override
            public void onError(Throwable e) { }
            @Override
            public void onComplete() { }
        });
    }
}
