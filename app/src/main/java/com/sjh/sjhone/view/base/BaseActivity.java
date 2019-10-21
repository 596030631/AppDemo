package com.sjh.sjhone.view.base;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import com.sjh.sjhone.App;
import com.sjh.sjhone.R;
import com.sjh.sjhone.presenter.base.BasePresenterImpl;

/**
 * date: 2019/10/16
 * author:SJH
 * description:
 */
public abstract class BaseActivity<T extends BasePresenterImpl> extends AppCompatActivity implements BaseActivityView , View.OnClickListener {
    protected T mPresenter;
    protected App mApp;
    protected static final String TAG = BaseActivity.class.getName();
    private LifecycleRegistry lifecycleRegistry;
    protected Toolbar mToolbar;
    protected boolean hasToolBar = false;

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
        setTopColor();
        mPresenter = bindPresenter();
        mPresenter.attachView(this);
        getLifecycle().addObserver(mPresenter);
        setContentView(initLayout());
        initView();
        if(hasToolBar) {
            setToolBar();
        }
    }
    protected void setToolBar() {
        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BaseActivity.this, "展示Nav", Toast.LENGTH_SHORT).show();
            }
        });
        mToolbar.inflateMenu(R.menu.toolbar_menu);
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_settings:
                        break;
                }
                return false;
            }
        });
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
        if(mPresenter != null) {
            mPresenter = null;
        }
    }

    /*
    * 反转导航栏字体颜色
    * */
    private void setTopColor(){
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);//设置绘画模式
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);//清除半透明模式
        boolean isDark = true;
        if (isDark) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);//黑色
        } else {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);//白色
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return true;
    }

    protected abstract T bindPresenter();
    protected abstract int initLayout();
    protected abstract void initView();

}
