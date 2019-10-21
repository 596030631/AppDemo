package com.sjh.sjhone.view.adapter;
import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
/**
 * date: 2019/10/21
 * author:SJH
 * description:
 */
public class LinearLayoutManagerKeepPage extends LinearLayoutManager implements RecyclerView.OnChildAttachStateChangeListener {

    private int mDrift;
    private PagerSnapHelper mPagerSnapHelper;
    private OnViewPagerListener mOnViewPagerListener;

    public LinearLayoutManagerKeepPage(Context context) {
        super(context);
    }
    public LinearLayoutManagerKeepPage(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
        mPagerSnapHelper = new PagerSnapHelper();
    }

    @Override
    public void onAttachedToWindow(RecyclerView view) {
        view.addOnChildAttachStateChangeListener(this);
        mPagerSnapHelper.attachToRecyclerView(view);
        super.onAttachedToWindow(view);
    }
    @Override
    public void onChildViewAttachedToWindow(@NonNull View view) {
        int position = getPosition(view);
        if (0 == position) {
            if (mOnViewPagerListener != null) {
                mOnViewPagerListener.onPageSelected(getPosition(view), false);
            }
        }
    }

    public void setOnViewPagerListener(OnViewPagerListener mOnViewPagerListener) {
        this.mOnViewPagerListener = mOnViewPagerListener;
    }

    @Override
    public void onScrollStateChanged(int state) {
        switch (state) {
            case RecyclerView.SCROLL_STATE_IDLE:
                View view = mPagerSnapHelper.findSnapView(this);
                int position = getPosition(view);
                if (mOnViewPagerListener != null) {
                    mOnViewPagerListener.onPageSelected(position, position == getItemCount() - 1);
                }

                break;
        }
        super.onScrollStateChanged(state);
    }

    @Override
    public void onChildViewDetachedFromWindow(@NonNull View view) {
        if (mDrift >= 0) {
            if (mOnViewPagerListener != null)
                mOnViewPagerListener.onPageRelease(true, getPosition(view));
        } else {
            if (mOnViewPagerListener != null)
                mOnViewPagerListener.onPageRelease(false, getPosition(view));
        }
    }

    @Override
    public int scrollVerticallyBy(int dy, RecyclerView.Recycler recycler, RecyclerView.State state) {
        this.mDrift = dy;
        return super.scrollVerticallyBy(dy, recycler, state);
    }

    @Override
    public boolean canScrollVertically() {
        return true;
    }
}
