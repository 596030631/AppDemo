package com.sjh.sjhone.view.activity;

import android.view.View;
import android.widget.ImageButton;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.sjh.sjhone.R;
import com.sjh.sjhone.presenter.MainPresenterImpl;
import com.sjh.sjhone.view.base.BaseActivity;
import com.sjh.sjhone.view.base.BaseFragment;
import com.sjh.sjhone.view.main.FragmentHomeImpl;
import com.sjh.sjhone.view.main.FragmentLoveImpl;
import com.sjh.sjhone.view.main.FragmentMineImpl;
import com.sjh.sjhone.view.main.FragmentSearchImpl;
import com.xiao.nicevideoplayer.NiceVideoPlayerManager;

public class MainViewActivity extends BaseActivity<MainPresenterImpl> implements MainView {

    private BaseFragment currentFragment;
    private FragmentManager fm;
    private ImageButton btnHome;
    private ImageButton btnSearch;
    private ImageButton btnLove;
    private ImageButton btnMine;

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected MainPresenterImpl bindPresenter() {
        return new MainPresenterImpl();
    }


    protected void initView() {
        btnHome = findViewById(R.id.btn_home);
        btnHome.setOnClickListener(this);
        btnSearch = findViewById(R.id.btn_search);
        btnSearch.setOnClickListener(this);
        btnLove = findViewById(R.id.btn_love);
        btnLove.setOnClickListener(this);
        btnMine = findViewById(R.id.btn_mine);
        btnMine.setOnClickListener(this);
        initData();
    }


    protected void initData() {
        btnLove.setImageResource(R.mipmap.icon_love_press);
        fm = getSupportFragmentManager();
        currentFragment = new FragmentLoveImpl();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.add(R.id.fragment, currentFragment).commit();
        transaction.show(currentFragment);
    }


    @Override
    public void onClick(View v) {
        resetButtonColor();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.hide(currentFragment);
        switch (v.getId()) {
            case R.id.btn_home:
                currentFragment = new FragmentHomeImpl();
                btnHome.setImageResource(R.mipmap.icon_home_press);
                break;
            case R.id.btn_search:
                currentFragment = new FragmentSearchImpl();
                btnSearch.setImageResource(R.mipmap.icon_search_press);
                break;
            case R.id.btn_love:
                currentFragment = new FragmentLoveImpl();
                btnLove.setImageResource(R.mipmap.icon_love_press);
                break;
            case R.id.btn_mine:
                currentFragment = new FragmentMineImpl();
                btnMine.setImageResource(R.mipmap.icon_mine_press);
                break;
        }
        transaction.add(R.id.fragment, currentFragment).commit();
        transaction.show(currentFragment);
    }

    private void resetButtonColor() {
        btnHome.setImageResource(R.mipmap.icon_home);
        btnSearch.setImageResource(R.mipmap.icon_search);
        btnLove.setImageResource(R.mipmap.icon_love);
        btnMine.setImageResource(R.mipmap.icon_mine);
    }

    @Override
    public void onBackPressed() {
        if (NiceVideoPlayerManager.instance().onBackPressd()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    public void showRefresh() {

    }

    @Override
    public void hideRefresh() {

    }
}

