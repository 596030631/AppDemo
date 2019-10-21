package com.sjh.sjhone.http.bean;

import java.util.List;

/**
 * date: 2019/10/19
 * author:SJH
 * description:
 */
public class BaseObjectBean<T> extends BaseBean {
    protected List<T> data;
    private String stat;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }
}
