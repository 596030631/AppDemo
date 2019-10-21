package com.sjh.sjhone.view.adapter;

/**
 * date: 2019/10/21
 * author:SJH
 * description:
 */
public interface OnViewPagerListener {

    void onInitComplete();

    void onPageRelease(boolean isNext, int position);

    void onPageSelected(int position, boolean isBottom);
}
