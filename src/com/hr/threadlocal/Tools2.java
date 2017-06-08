package com.hr.threadlocal;

/**
 * 在 初始化的时候就 设置值
 * Created by Administrator on 2017/6/7 0007.
 */
public class Tools2 extends ThreadLocal{

    @Override
    protected Object initialValue() {
        //return super.initialValue();
        return "default";
    }
}
