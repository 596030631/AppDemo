package com.sjh.sjhone.base;
import androidx.lifecycle.LifecycleOwner;

import com.sjh.baselibrary.util.Logger;

import java.lang.ref.WeakReference;
import static com.sjh.sjhone.App.MyApp;
/**
 * date: 2019/10/16
 * author:SJH
 * description:
 */
public abstract class BasePresenterImpl<T extends BaseView,V extends BaseModel> implements BasePresenter {
    public V mModel;
    public BasePresenterImpl(){
        mModel = initModel();
    }

    protected WeakReference<T> mViewRef;
    protected void attachView(T view) {
        mViewRef = new WeakReference<T>(view);
    }

    protected void detachView(){
        if(mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }
    }

    protected T getView(){
        if(mViewRef == null) {
            return null;
        }
        return mViewRef.get();
    }

    public abstract V initModel();

    @Override
    public void onCreate(LifecycleOwner owner) {
        Logger.i(MyApp.getPackageName(),"------------------create------------------------");
    }

    @Override
    public void onStart(LifecycleOwner owner) {
        Logger.i(MyApp.getPackageName(),"------------------start------------------------");
    }

    @Override
    public void onResume(LifecycleOwner owner) {
        Logger.i(MyApp.getPackageName(),"------------------Resume------------------------");
    }

    @Override
    public void onPause(LifecycleOwner owner) {
        Logger.i(MyApp.getPackageName(),"------------------Pause------------------------");
    }

    @Override
    public void onDestroy(LifecycleOwner owner) {
        if(mModel != null) {
            mModel.onDestory();
            mModel = null;
        }
        Logger.i(MyApp.getPackageName(),"------------------destory------------------------");
    }

}
