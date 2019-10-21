package com.sjh.sjhone.view.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.sjh.sjhone.R;
import com.sjh.sjhone.bean.VideoBean;
import com.xiao.nicevideoplayer.NiceVideoPlayer;
import com.xiao.nicevideoplayer.TxVideoPlayerController;
/**
 * date: 2019/10/21
 * author:SJH
 * description:
 */
public class VideoViewHolder extends RecyclerView.ViewHolder{
    public TxVideoPlayerController mController;
    public NiceVideoPlayer mVideoPlayer;

    public VideoViewHolder(View itemView) {
        super(itemView);
        mVideoPlayer = (NiceVideoPlayer) itemView.findViewById(R.id.nice_video_player);
        ViewGroup.LayoutParams params = mVideoPlayer.getLayoutParams();
        params.width = itemView.getResources().getDisplayMetrics().widthPixels; // 宽度为屏幕宽度
        params.height = itemView.getResources().getDisplayMetrics().heightPixels; // 宽度为屏幕宽度
        //params.height = (int) (params.width * 9f / 16f);    // 高度为宽度的9/16
        mVideoPlayer.setLayoutParams(params);
        mVideoPlayer.start();
    }

    public void setController(TxVideoPlayerController controller) {
        mController = controller;
        mVideoPlayer.setController(mController);
    }

    public void bindData(VideoBean video) {
        mController.setTitle(video.getTitle());
        mController.setLenght(video.getLength());
        Glide.with(itemView.getContext())
                .load("")
                .apply(new RequestOptions().error(R.drawable.shape_rect_black)
                        .fallback(R.drawable.shape_rect_black)
                .override(30,30))
                .into(mController.imageView());
        mVideoPlayer.setUp(video.getVideoUrl(), null);
    }
}
