package com.sjh.sjhone.view.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sjh.sjhone.R;
import com.sjh.sjhone.view.base.BaseFragment;
import com.sjh.sjhone.presenter.main.SearchPresenterImpl;

/**
 * date: 2019/10/19
 * author:SJH
 * description:
 */
public class FragmentSearchImpl extends BaseFragment<SearchPresenterImpl> implements SearchView {
    @Override
    protected SearchPresenterImpl attachPresenter() {
        return new SearchPresenterImpl();
    }

    @Override
    public View setContentUI(LayoutInflater inflater, ViewGroup container) {
        View view = View.inflate(getContext(), R.layout.fragment_search, null);
        return view;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void initData(Context mContext) {

    }
}
