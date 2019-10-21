package com.sjh.sjhone.view.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.sjh.sjhone.R;
import com.sjh.sjhone.http.bean.TouTiaoBean;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * date: 2019/10/19
 * author:SJH
 * description:
 */
public class HomeMainAdapter extends RecyclerView.Adapter<HomeMainAdapter.VH>{

    protected int mPosition = -1;
    private List<TouTiaoBean> mList;
    private List<List<String>> mImageUrl;
    private Context mContext;
    private VH.ViewPagerAdapter adapter;
    private List<ImageView> mImage;

    public HomeMainAdapter(Context ctx,List<TouTiaoBean> list,List<List<String>> image){
        mList = list;
        mContext = ctx;
        mImageUrl = image;
    }
    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_home_main, parent, false);
        VH vh = new VH(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull final VH holder, int position) {
        mPosition = position;
        holder.newsTitle.setText(mList.get(position).getTitle());
        holder.newsDetail.setText(mList.get(position).getAuthor_name());
        mImage = new ArrayList<>();
        List<String> urlList = new ArrayList<>();
        urlList.addAll(mImageUrl.get(position));
        for (int i = 0; i < urlList.size(); i++) {
            ImageView iv = new ImageView(mContext);
            iv.setScaleType(ImageView.ScaleType.FIT_XY);
            mImage.add(iv);
        }
        for (int j = 0; j < mImage.size(); j++) {
            final WeakReference<ImageView> imageViewWeakReference1 = new WeakReference<>(mImage.get(j));
            final ImageView target = imageViewWeakReference1.get();
            if (target != null) {
                Glide.with(mContext)
                        .load(mImageUrl.get(position).get(j))
                        .into(new SimpleTarget<Drawable>() {
                            @Override
                            public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                                target.setImageDrawable(resource);
                            }
                        });
            }
        }
        adapter = new VH.ViewPagerAdapter(mImage);
        holder.newsViewPage.setAdapter(adapter);
    }
    @Override
    public int getItemCount() {
        return mList.size();
    }

    protected static class VH extends RecyclerView.ViewHolder {
        TextView newsTitle;
        TextView newsDetail;
        ViewPager newsViewPage;
        TextView imageIndex;

        public VH(@NonNull View itemView) {
            super(itemView);
            newsTitle = itemView.findViewById(R.id.news_title);
            newsDetail = itemView.findViewById(R.id.news_detail);
            newsViewPage = itemView.findViewById(R.id.viewPager);
            imageIndex = itemView.findViewById(R.id.imageIndex);
        }

        protected static class ViewPagerAdapter extends PagerAdapter {
            private List<ImageView> mImageList;
            public ViewPagerAdapter(List<ImageView> list){
                mImageList = list;
            }
            @Override
            public int getCount() {
                return mImageList.size();
            }
            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
                return view == object;
            }
            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {
                container.addView(mImageList.get(position));
                return mImageList.get(position);
            }
            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
                container.removeView(mImageList.get(position));
            }
        }
    }
}
