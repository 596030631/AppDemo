package com.sjh.sjhone.view.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sjh.sjhone.R;
import com.sjh.sjhone.bean.VideoBean;
import com.sjh.sjhone.view.adapter.LinearLayoutManagerKeepPage;
import com.sjh.sjhone.view.adapter.LoveMainAdapter;
import com.sjh.sjhone.view.adapter.OnViewPagerListener;
import com.sjh.sjhone.view.adapter.VideoViewHolder;
import com.sjh.sjhone.view.base.BaseFragment;
import com.sjh.sjhone.presenter.main.LovePresenterImpl;
import com.xiao.nicevideoplayer.NiceVideoPlayer;
import com.xiao.nicevideoplayer.NiceVideoPlayerManager;

import java.util.ArrayList;
import java.util.List;

/**
 * date: 2019/10/19
 * author:SJH
 * description:
 */
public class FragmentLoveImpl extends BaseFragment<LovePresenterImpl> implements LoveView {

    private RecyclerView mRecycler;
    private LoveMainAdapter mAdapter;

    @Override
    protected LovePresenterImpl attachPresenter() {
        return new LovePresenterImpl();
    }

    @Override
    public View setContentUI(LayoutInflater inflater, ViewGroup container) {
        View view = View.inflate(getContext(), R.layout.fragment_love, null);
        return view;
    }
    @Override
    protected void initView(View view) {
        mRecycler = view.findViewById(R.id.mRecycler_love);
        LinearLayoutManagerKeepPage mLayout = new LinearLayoutManagerKeepPage(mContext,LinearLayoutManagerKeepPage.VERTICAL,false);
        mRecycler.setLayoutManager(mLayout);
        mLayout.setOnViewPagerListener(new OnViewPagerListener() {
            @Override
            public void onInitComplete() {

            }
            @Override
            public void onPageRelease(boolean isNext, int position) {

            }
            @Override
            public void onPageSelected(int position, boolean isBottom) {
                VideoViewHolder holder = new VideoViewHolder(mRecycler);
                holder.mVideoPlayer.start();
            }
        });
    }

    @Override
    protected void initData(Context mContext) {
        mPresenter.initData();
        mAdapter = mPresenter.getAdapter(getActivity());
        mRecycler.setAdapter(mAdapter);
        mRecycler.setHasFixedSize(true);
        mRecycler.setRecyclerListener(new RecyclerView.RecyclerListener() {
            @Override
            public void onViewRecycled(RecyclerView.ViewHolder holder) {
                NiceVideoPlayer niceVideoPlayer = ((VideoViewHolder) holder).mVideoPlayer;
                if (niceVideoPlayer == NiceVideoPlayerManager.instance().getCurrentNiceVideoPlayer()) {
                    NiceVideoPlayerManager.instance().releaseNiceVideoPlayer();
                }
            }
        });
    }

    @Override
    public void onStop() {
        super.onStop();
        NiceVideoPlayerManager.instance().releaseNiceVideoPlayer();
    }

}
