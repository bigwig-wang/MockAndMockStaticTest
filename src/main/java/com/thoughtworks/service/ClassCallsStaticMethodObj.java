package com.thoughtworks.service;

/**
 * Created by dhwang on 11/10/2017.
 */
public class ClassCallsStaticMethodObj {
    public String excute(int value) {

        String s = Static.firstStaticMethod(value);
        String s1 = Static.secondeMethod();
        return s + s1;
    }
}
