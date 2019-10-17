package com.sjh.sjhone.view.ui;
import android.os.Bundle;
import com.sjh.sjhone.R;
import com.sjh.sjhone.base.BaseActivity;
import com.sjh.sjhone.base.BasePresenterImpl;
import com.sjh.sjhone.view.presenter.MainActivityPresenterImpl;

public class MainActivity extends BaseActivity implements IMainActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mApp.showImageToast(getResources().getText(R.string.toast_text_empty).toString(),R.drawable.ic_launcher_background);
    }

    @Override
    protected BasePresenterImpl bindPresenter() {
        return new MainActivityPresenterImpl();
    }

    @Override
    protected void initView() {


    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initEvent() {

    }
}
