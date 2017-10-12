package com.thoughtworks.service;

/**
 * Created by dhwang on 11/10/2017.
 */
public class Static {
    public static String firstStaticMethod(int value) {
        System.out.println("excute firstStaticMethod");
        return value + "";
    }

    public static String secondeMethod() {
        System.out.println("excute secondStaticMethod");
        return "4";
    }
}
