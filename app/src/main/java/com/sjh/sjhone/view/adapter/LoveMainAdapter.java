package com.sjh.sjhone.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.sjh.sjhone.R;
import com.sjh.sjhone.bean.VideoBean;
import com.xiao.nicevideoplayer.NiceVideoPlayer;
import com.xiao.nicevideoplayer.TxVideoPlayerController;
import java.util.List;

/**
 * date: 2019/10/19
 * author:SJH
 * description:
 */
public class LoveMainAdapter extends RecyclerView.Adapter<VideoViewHolder>{
    private Context mContext;
    private List<VideoBean> mVideoList;
    public LoveMainAdapter(Context context, List<VideoBean> videoList) {
        mContext = context;
        mVideoList = videoList;
    }
    @Override
    public VideoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.item_love_main, parent, false);
        VideoViewHolder holder = new VideoViewHolder(itemView);
        TxVideoPlayerController controller = new TxVideoPlayerController(mContext);
        holder.setController(controller);
        return holder;
    }
    @Override
    public void onBindViewHolder(VideoViewHolder holder, int position) {
        VideoBean video = mVideoList.get(position);
        holder.bindData(video);

    }
    @Override
    public int getItemCount() {
        return mVideoList.size();
    }

}
