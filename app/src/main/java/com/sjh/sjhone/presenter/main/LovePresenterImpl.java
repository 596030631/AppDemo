package com.sjh.sjhone.presenter.main;

import android.content.Context;
import android.text.TextUtils;

import com.sjh.sjhone.bean.VideoBean;
import com.sjh.sjhone.http.bean.VideoTopBean;
import com.sjh.sjhone.model.LoveModel;
import com.sjh.sjhone.model.LoveModelImpl;
import com.sjh.sjhone.presenter.base.BasePresenterImpl;
import com.sjh.sjhone.view.adapter.LoveMainAdapter;
import com.sjh.sjhone.view.main.LoveView;
import java.util.ArrayList;
import java.util.List;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * date: 2019/10/19
 * author:SJH
 * description:
 */
public class LovePresenterImpl extends BasePresenterImpl<LoveView, LoveModel> {

    private List<VideoTopBean.DataBean> mList;
    private List<VideoBean> mVideoList;

    private LoveMainAdapter mAdapter;
    @Override
    public LoveModel initModel() {
        return new LoveModelImpl();
    }

    public LoveMainAdapter getAdapter(Context context){
        if(mAdapter == null) {
            mAdapter = new  LoveMainAdapter(context,mVideoList);
        }
        return  mAdapter;
    }

    @Override
    public void initData() {
        mList = new ArrayList<>();
        mVideoList = new ArrayList<>();
        int type = 1;
        int page = 1;
        mModel.getVideos(String.valueOf(type),String.valueOf(page),new Observer<VideoTopBean>() {
            @Override
            public void onSubscribe(Disposable d) { }
            @Override
            public void onNext(VideoTopBean videoTopBean) {
                mList.addAll(videoTopBean.getData());
                for (int i = 0; i < mList.size(); i++) {
                    if(!TextUtils.isEmpty(mList.get(i).getVideouri())) {
                        VideoBean bean = new VideoBean();
                        bean.setTitle(mList.get(i).getText());
                        bean.setImageUrl(mList.get(i).getProfile_image());
                        bean.setVideoUrl(mList.get(i).getVideouri());
                        bean.setLength(mList.get(i).getVideotime()*60);
                        mVideoList.add(bean);
                    }
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
