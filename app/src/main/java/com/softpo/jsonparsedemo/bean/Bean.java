package com.softpo.jsonparsedemo.bean;

import java.util.List;

/**
 * Created by softpo on 2016/5/10.
 */
public class Bean {
    private String error;

    private List<Object> datas;
    private List<BeanTwo> data;

    public List<BeanTwo> getData() {
        return data;
    }

    public void setData(List<BeanTwo> data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<Object> getDatas() {
        return datas;
    }

    public void setDatas(List<Object> data) {
        this.datas = data;
    }
}
