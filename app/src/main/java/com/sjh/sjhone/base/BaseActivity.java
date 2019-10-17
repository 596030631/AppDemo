package com.sjh.sjhone.base;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import com.sjh.sjhone.App;

/**
 * date: 2019/10/16
 * author:SJH
 * description:
 */
public abstract class BaseActivity<T extends BasePresenterImpl> extends AppCompatActivity implements BaseView{
    protected T mPresenter;
    protected App mApp;
    protected static final String TAG = BaseActivity.class.getName();
    private LifecycleRegistry lifecycleRegistry;

    @Override
    public Lifecycle getLifecycle() {
        if(lifecycleRegistry == null){
            lifecycleRegistry = new LifecycleRegistry(this);
        }
        return lifecycleRegistry;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = bindPresenter();
        getLifecycle().addObserver(mPresenter);

        initView();
        initData();
        initEvent();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
        if(mPresenter != null) {
            mPresenter = null;
        }
    }

    protected abstract T bindPresenter();
    protected abstract void initView();
    protected abstract void initData();
    protected abstract void initEvent();

}
