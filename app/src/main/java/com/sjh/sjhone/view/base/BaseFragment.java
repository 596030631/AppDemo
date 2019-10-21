package com.sjh.sjhone.view.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;

import com.sjh.sjhone.base.BaseView;
import com.sjh.sjhone.presenter.base.BasePresenterImpl;

/**
 * date: 2019/10/19
 * author:SJH
 * description:
 */
public abstract class BaseFragment<T extends BasePresenterImpl> extends Fragment implements BaseView, LifecycleOwner {

    protected final String TAG = this.getClass().getSimpleName();
    protected T mPresenter;
    public Context mContext;
    public View rootView;

    public BaseFragment(){ mPresenter = attachPresenter();}
    @Override
    public void onAttach(Context ctx) {
        super.onAttach(ctx);
        mContext = ctx;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = setContentUI(inflater, container);
        } else {
            if (rootView.getParent() != null) {
                ((ViewGroup) rootView.getParent()).removeView(rootView);
            }
        }
        initView(rootView);
        initData(mContext);
        return rootView;
    }
    public abstract View setContentUI(LayoutInflater inflater, ViewGroup container);
    protected abstract void initView(final View view);
    protected abstract void initData(Context mContext);
    protected abstract T attachPresenter();


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
       return;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    private LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);
    @NonNull
    @Override
    public Lifecycle getLifecycle() {
        return super.getLifecycle();
    }

}
