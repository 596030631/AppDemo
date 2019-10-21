package com.sjh.sjhone.view.base;

import androidx.lifecycle.LifecycleOwner;

import com.sjh.sjhone.base.BaseView;


/**
 * date: 2019/10/20
 * author:SJH
 * description:
 */
public interface BaseActivityView extends BaseView, LifecycleOwner {
    void showRefresh();
    void hideRefresh();
}
