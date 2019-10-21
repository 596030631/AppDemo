package com.sjh.sjhone.view.activity;

import android.content.Context;
import android.view.View;
import com.google.android.material.textfield.TextInputEditText;
import com.sjh.sjhone.R;
import com.sjh.sjhone.view.base.BaseActivity;
import com.sjh.sjhone.presenter.base.BasePresenterImpl;
import com.sjh.sjhone.presenter.LoginPresenterImpl;

public class LoginViewActivity extends BaseActivity implements LoginView {

    @Override
    protected BasePresenterImpl bindPresenter() {
        return new LoginPresenterImpl();
    }

    @Override
    protected int initLayout() { return R.layout.activity_login; }

    @Override
    protected void initView() {

    }


    @Override
    public void onClick(View v) {

    }

    @Override
    public void showRefresh() {

    }

    @Override
    public void hideRefresh() {

    }
}
