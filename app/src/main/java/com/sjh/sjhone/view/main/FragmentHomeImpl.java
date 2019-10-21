package com.sjh.sjhone.view.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.sjh.sjhone.R;
import com.sjh.sjhone.presenter.main.HomePresenterImpl;
import com.sjh.sjhone.view.base.BaseFragment;

/**
 * date: 2019/10/19
 * author:SJH
 * description:
 */
public class FragmentHomeImpl extends BaseFragment<HomePresenterImpl> implements HomeView {

    private RecyclerView mRecycler;

    @Override
    protected HomePresenterImpl attachPresenter() { return  new HomePresenterImpl();}

    @Override
    public View setContentUI(LayoutInflater inflater, ViewGroup container) {
        View view = View.inflate(getContext(), R.layout.fragment_home, null);
        return view;
    }

    @Override
    protected void initView(View view) {
        mRecycler = view.findViewById(R.id.mRecycler_home);
        mRecycler.setLayoutManager( new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));
    }

    @Override
    protected void initData(Context mContext) {
        mPresenter.initData();
        mRecycler.setAdapter(mPresenter.getAdapter(getActivity()));
    }

}
