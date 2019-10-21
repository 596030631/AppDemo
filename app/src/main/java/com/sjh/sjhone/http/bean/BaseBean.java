package com.sjh.sjhone.http.bean;

/**
 * date: 2019/10/19
 * author:SJH
 * description:
 */
public class BaseBean<T>{

    protected T result;
    private String reason;
    private int error_code;

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }
}
