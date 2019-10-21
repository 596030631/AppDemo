package com.sjh.sjhone.view.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.sjh.sjhone.R;
import com.sjh.sjhone.view.base.BaseFragment;
import com.sjh.sjhone.presenter.main.MinePresenterImpl;

/**
 * date: 2019/10/19
 * author:SJH
 * description:
 */
public class FragmentMineImpl extends BaseFragment<MinePresenterImpl> implements MineView {
    @Override
    protected MinePresenterImpl attachPresenter() {
        return new MinePresenterImpl();
    }

    @Override
    public View setContentUI(LayoutInflater inflater, ViewGroup container) {
        View view = View.inflate(getContext(), R.layout.fragment_mine, null);
        return view;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void initData(Context mContext) {

    }
}
